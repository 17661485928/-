package com.coffee.kafeisummary.config;

import com.coffee.kafeisummary.pojo.ResultObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.concurrent.CountDownLatch;

/**
 * @author kafei
 * @Title: TomcatServer
 * @Package
 * @Description: 通过java代码控制指定位置的tomcat的启动或关闭
 * 如果使用java代码启动外部tomcat服务失败，请先检查外部tomcat的环境变量配置的是否正确。
 * 如若还是不行请进入tomcat的bin目录下找到catalina.bat此文件，修改set "CURRENT_DIR=E:\work\apache-tomcat-8.5.45"（实例）
 * set "CURRENT_DIR=tomcat的安装目录"记住不要带有之前的%；
 * @date 2020/7/7 9:51
 */
public class TomcatServer {
    static Logger logger = LoggerFactory.getLogger(TomcatServer.class);

    /**
     * 启动tomcat
     *
     * @return
     */
    public static ResultObject start(String tomcatRootPath,String httpAddr) {
        final ResultObject resultObject = new ResultObject();
        resultObject.setResult(false);
        if (StringUtils.isBlank(tomcatRootPath)) {
            return resultObject;
        }
        //Address already in use: bind
        //Server startup in 16546 ms
        String startPath = tomcatRootPath + "\\bin";
        BufferedReader in = null;
        // 启动tomcat命令
        String execCommond = startPath + "\\catalina.bat run";
        logger.info("***************开始启动tomcat，执行命令为*************" + execCommond);
        Process process = null;
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        try {
            process = Runtime.getRuntime().exec(execCommond);
            printTomcatConsolMessage(process.getErrorStream(), "ErrorStream", countDownLatch, resultObject);//先输出错误流
            printTomcatConsolMessage(process.getInputStream(), "OutPutStream", countDownLatch, resultObject);//再输出标准流
            countDownLatch.await();//主线程等待子线程结束
            logger.info(tomcatRootPath + "Tomcat启动操作结束：返回状态为==" + resultObject.isResult());
            logger.info(tomcatRootPath + "Tomcat启动操作结束：返回返回信息==" + resultObject.getMsg());
            if (!resultObject.isResult() && !"端口已被占用".equals(resultObject.getMsg())) {
                stop(startPath,httpAddr);
            }
            logger.info(">>>>>>>>>>>>>>>内置服务启动成功 访问地址：http://localhost:8080/");
        } catch (Exception e) {
            resultObject.setResult(false);
            resultObject.setMsg("启动tomcat出现异常。");
            logger.error("启动tomcat出现异常。");
            e.printStackTrace();
            return resultObject;
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
                if (null != process) {
                    process.destroy();
                }
            } catch (Exception e) {
                resultObject.setResult(false);
                resultObject.setMsg("启动tomcat出现异常。");
                logger.error("启动tomcat出现异常。");
                e.printStackTrace();
                return resultObject;
            }
        }
        return resultObject;
    }

    /**
     * 关闭tomcat
     *
     * @param tomcatRootPath tomcat根路径
     * @return
     */
    public static ResultObject stop(String tomcatRootPath,String httpAddr) {
        final ResultObject resultObject = new ResultObject();
        resultObject.setResult(false);
        if (StringUtils.isBlank(tomcatRootPath)) {
            return resultObject;
        }
        String startPath = tomcatRootPath + "\\bin";
        BufferedReader in = null;
        Process process = null;
        // 关闭命令
        String execCommond = startPath + "\\catalina.bat stop";
        logger.info("***************开始关闭tomcat，执行命令为***********" + execCommond);
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        try {
            process = Runtime.getRuntime().exec(execCommond);
            printTomcatConsolMessage(process.getErrorStream(), "error", countDownLatch, resultObject);
            printTomcatConsolMessage(process.getInputStream(), "input", countDownLatch, resultObject);
            countDownLatch.await();
            logger.info(tomcatRootPath + ":Tomcat关闭操作结束：返回状态为==" + resultObject.isResult());
            logger.info(tomcatRootPath + ":Tomcat关闭操作结束：返回返回信息==" + resultObject.getMsg());
            logger.info(tomcatRootPath + ":>>>>>>>>>>>>>>>内置服务<停止>成功 地址:"+httpAddr);
        } catch (Exception e) {
            resultObject.setResult(false);
            resultObject.setMsg("关闭tomcat出现异常。");
            logger.error("关闭tomcat出现异常。");
            e.printStackTrace();
            return resultObject;
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
                if (null != process) {
                    process.destroy();
                }
            } catch (Exception e) {
                resultObject.setResult(false);
                resultObject.setMsg("关闭tomcat出现异常。");
                logger.error("关闭tomcat出现异常。");
                e.printStackTrace();
                return resultObject;
            }
        }
        return resultObject;
    }

    /**
     * 另起线程，输出输入流，为启动和关闭tomcat服务
     *
     * @param input          输入流
     * @param typeInfo       输出信息 ErrorStream or OutPutStream
     * @param countDownLatch 定时器对象 控制父线程是否继续
     * @param resultObject   返回结果对象
     */
    private static void printTomcatConsolMessage(final InputStream input, final String typeInfo, final CountDownLatch countDownLatch, final ResultObject resultObject) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                InputStreamReader reader = null;
                try {
                    reader = new InputStreamReader(input, "GBK");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                BufferedReader bf = new BufferedReader(reader);
                String line = null;
                String successFlag = "start Server startup in";
                String addrressUsed = "Address already in use: bind";
                String exception = "ERROR";
                int i = 0;
                resultObject.setResult(true);
                try {
                    while ((line = bf.readLine()) != null) {
//                        System.out.println(line);
                        if (StringUtils.isNotBlank(line)) {
                            line = line.trim();
                            //捕获错误信息
                            if (line.indexOf(exception) > -1) {
                                resultObject.setMsg("tomcat启动发生异常：" + line.substring(line.indexOf("ERROR") + 5, line.length()));
                                resultObject.setResult(false);
                                if (countDownLatch.getCount() > 0) {
                                    countDownLatch.countDown();
                                }
                            }
                            if (line.indexOf(successFlag) > -1) {
                                //正常启动完毕信息
                                resultObject.setMsg("启动成功,启动耗时：" + line.substring(line.indexOf("startup in") + 11, line.length()));
                                resultObject.setResult(true);
                                if (countDownLatch.getCount() > 0) {
                                    countDownLatch.countDown();
                                }
                                break;
                            } else if (line.indexOf(addrressUsed) > -1) {
                                //捕获端口占用信息
                                resultObject.setMsg("端口已被占用");
                                resultObject.setResult(false);
                                if (countDownLatch.getCount() > 0) {
                                    countDownLatch.countDown();
                                }
                            }
                        }
                    }
                    if (countDownLatch.getCount() > 0) {
                        countDownLatch.countDown();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (null != bf) {
                        try {
                            bf.close();
                        } catch (IOException e) {
                            resultObject.setResult(false);
                            e.printStackTrace();
                        }
                    }
                    if (null != reader) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            resultObject.setResult(false);
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
