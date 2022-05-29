using System.Text;


StringBuilder sb = new StringBuilder(); //string will be appended later
StringBuilder sb = new StringBuilder("Hello World!");

var greet = sb.ToString();
sb.Append("Hello ");
sb.AppendLine("World!");

sbAmout.AppendFormat("{0:C} ", 25);

sb.Insert(5, " C#");

sb.Remove(6, 7);

sb.Replace("World", "C#");
