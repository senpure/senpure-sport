@echo off
set registryPath="HKCU\Console\%%SystemRoot%%_system32_cmd.exe"
reg add %registryPath% /v "WindowPosition" /t REG_DWORD /d 0x00080008 /f>nul
reg add %registryPath% /v "ScreenBufferSize" /t REG_DWORD /d 0x03e800c8 /f>nul
reg add %registryPath% /v "WindowSize" /t REG_DWORD /d 0x03200c8 /f>nul
if not defined flag (set flag=0&start cmd /c %0 %1&(exit))
reg delete %registryPath% /f>nul
set currentPath=%cd%
set fileName=""
for  %%a in (*) do (
   echo %%a|findstr /e /i ".jar" >nul && set fileName=%%a
)
if %fileName% =="" (
    echo 没有找到可运行的jar文件
    goto :fiveSecondsExit
)
title %fileName%
java -jar %jarName%
:fiveSecondsExit
echo 5秒后关闭该窗口,要想停止请按ctrl + c
ping /n 2 127.1 >nul
echo 4秒后关闭该窗口,要想停止请按ctrl + c
ping /n 2 127.1 >nul
echo 3秒后关闭该窗口,要想停止请按ctrl + c
ping /n 2 127.1 >nul
echo 2秒后关闭该窗口,要想停止请按ctrl + c
ping /n 2 127.1 >nul
echo 1秒后关闭该窗口,要想停止请按ctrl + c
ping /n 2 127.1 >nul
:exit

