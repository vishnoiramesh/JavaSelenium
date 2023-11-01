WinWaitActive("File Upload", "", 5);
ControlSend("File Upload", "", "[CLASS:Edit; INSTANCE:1]", "C:/autoit_scripts/CV.txt");
ControlClick("File Upload", "", "[CLASS:Button; INSTANCE:1]");