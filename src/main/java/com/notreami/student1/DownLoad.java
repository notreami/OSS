package com.notreami.student1;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Created by notreami on 15/12/23.
 */
@WebServlet("/downLoad")
public class DownLoad extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public DownLoad(){
        super();
    }
    protected void doGet(HttpServletRequest request , HttpServletResponse response)
            throws ServletException,IOException {
        this.doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        try{
            //服务器相对路径
            String filepath = "WEB-INF/web.xml";
            //服务器绝对路径
            String fullFilePath = getServletContext().getRealPath(filepath);
            System.out.println(fullFilePath);
            /*打开文件，创建File类型的文件对象*/
            File file = new File(fullFilePath);
            /*如果文件存在*/
            if(file.exists()){
                System.out.println("文件存在");
                /*获得文件名，并采用UTF-8编码方式进行编码，以解决中文问题*/
                String filename = URLEncoder.encode(file.getName(), "UTF-8");
                System.out.println(filename);
                /*重置response对象*/
                response.reset();
                //设置文件的类型，xml文件采用text/xml类型，详见MIME类型的说明
                response.setContentType("text/xml");
                //设置HTTP头信息中内容
                response.addHeader("Content-Disposition","attachment:filename=\"" + filename + "\"" );
                //设置文件的长度
                int fileLength = (int)file.length();
                System.out.println(fileLength);
                response.setContentLength(fileLength);
                /*如果文件长度大于0*/
                if(fileLength!=0){
                    //创建输入流
                    InputStream inStream = new FileInputStream(file);
                    byte[] buf = new byte[4096];
                    //创建输出流
                    ServletOutputStream servletOS = response.getOutputStream();
                    int readLength;
                    //读取文件内容并写到response的输出流当中
                    while(((readLength = inStream.read(buf))!=-1)){
                        servletOS.write(buf, 0, readLength);
                    }
                    //关闭输入流
                    inStream.close();
                    //刷新输出缓冲
                    servletOS.flush();
                    //关闭输出流
                    servletOS.close();
                }
            }else {
                System.out.println("文件不存在~！");
                PrintWriter out = response.getWriter();
                out.println("文件 \"" + fullFilePath + "\" 不存在");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
