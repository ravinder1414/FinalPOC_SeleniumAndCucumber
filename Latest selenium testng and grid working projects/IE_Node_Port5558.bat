cd C:\JAVA_PROJECTS\Demo\Libs
java -jar C:\JAVA_PROJECTS\Demo\Libs\selenium-server-standalone-2.46.0.jar -role webdriver -hub http://localhost:4444/grid/register -browser browserName="internet explorer",version=10,platform=WINDOWS -Dwebdriver.internetexplorer.driver="C:\JAVA_PROJECTS\Demo\Libs\IEDriverServer.exe"