using System;
using System.Diagnostics;


namespace ConsoleApp1
{

    class Program
    {
        public static void Main(String[] args)
        {
            Console.WriteLine("What is the Username?");

            String str = Console.ReadLine();

            Console.WriteLine("Your username is: " + str);

            Console.WriteLine("What is the Password?");

            String str2 = Console.ReadLine();

            Console.WriteLine("Your password is: " + str2);

            if ((str == "user") && (str2 == "application"))
            {
                Console.WriteLine("The username and password match.");



                Process myProcess = new Process();
                myProcess.StartInfo.UseShellExecute = false;
                myProcess.StartInfo.FileName = "java";
                myProcess.StartInfo.Arguments = ("-jar C:\\Users\\assem\\JavaFX_Project_3.jar");
                myProcess.Start();


            }

        }
    } 
}
