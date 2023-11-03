# 1. Создать директорию, переместить файл туда.
### cat > Pets
### cat > PackAnimals
### cat Pets PackAnimals > HumanFriends
### cat HumanFriends
### mv HumanFriends Animal_Friends
### mkdir Animals
### mv Animal_Friends Animals
### cd Animals/
### ls
![img.png](img.png)
![img_1.png](img_1.png)
![img_2.png](img_2.png)
# 2. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.
# 3. Установить и удалить deb-пакет с помощью dpkg.
# 4. Выложить историю команд в терминале ubuntu.
### apt-get install gnupg
### sudo wget https://dev.mysql.com/get/mysql-apt-config_0.8.28-1_all.deb
### dpkg -i mysql-apt-config_0.8.28-1_all.deb
### sudo apt-get update
### sudo apt-get install mysql-server
### sudo dpkg -r mysql-apt-config_0.8.28-1_all
### history
![img_3.png](img_3.png)
![img_4.png](img_4.png)
![img_5.png](img_5.png)
![img_6.png](img_6.png)
![img_7.png](img_7.png)
![img_8.png](img_8.png)
![img_9.png](img_9.png)
