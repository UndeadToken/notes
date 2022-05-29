class Student
{
    public int StudentID { get; set; }
    public string StudentName { get; set; }
}

[Serializable]
class InvalidStudentNameException : Exception
{
    public InvalidStudentNameException() { }

    public InvalidStudentNameException(string name)
        : base(String.Format("Invalid Student Name: {0}", name))
    {

    }
}
