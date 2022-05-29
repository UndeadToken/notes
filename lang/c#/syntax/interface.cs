interface IFile
{
    void ReadFile();
    void WriteFile(string text);
}

class FileInfo : IFile
{
    public void ReadFile()
    {
        Console.WriteLine("Reading File");
    }

    public void WriteFile(string text)
    {
        Console.WriteLine("Writing to file");
    }
}

//class FileInfo : IFile
//{
//    void IFile.ReadFile()
//    {
//        Console.WriteLine("Reading File");
//    }

//class FileInfo : IFile, IBinaryFile