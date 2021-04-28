# Computer components online store project 

#### Чтобы подключиться к проекту, необходимо:
1) Скачать и установить базу данных **PostgreSQL** с сайта
https://www.postgresql.org/download/
2) При помощи утилиты **pgAdmin.exe**, которая была установлена вместе с базой данных, перейти в администрирование баз данных.
3) Задать любой пароль или оставить пароль по дефолту.
4) Создать базу данных с любым именем.
5) В Intellij IDEA создать проект с имеющегося репозитория: **File -> New -> Project from Version Control**
6) После создания проекта в Intellij IDEA перейти в меню **Edit configurations...** и настроить переменные среды(**Environment variables**) 
7) Создаем 3 новые переменные:  
  **bd.url** со значением  *jdbc:postgresql://localhost:5432/{insert your database name}*   
  **bd.username** с именем вашего пользователя в базе данных  
  **bd.password** с паролем, который вы установили для подключения к вашей базе данных 
8) В окне браузера перейти по адресу: http://localhost:8082/hello
