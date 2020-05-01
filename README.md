# Relocation-System
大连理工大学软件学院校内实习-动迁系统
开发工具 IDEA
开发环境 Node.js1.10 JDK1.8 MySQL5.7
前端项目：vue(运行于8080端口)  后端项目：Springboot(运行于8888端口) 数据库：MySQL

项目运行(在服务器端)
2.服务器开放8888端口
1.MySQL执行test.sql 建库
2.将前端项目(relocation)
2.前端项目执行cnpm run build 打包，将前端项目的/Demo1/dist文件夹里的所有内容复制进后端项目\src\main\resources\static文件夹下
2.文本编辑器打开后端项目(test) \src\main\resources\application.properties文件，将spring.datasource.username,spring.datasource.password修改为自己MySQL的账号密码。运行TestApplication.java类
2.浏览器访问http://服务器公网IP:8888 

项目网址：http://lishan6.top:8888 欢迎访问