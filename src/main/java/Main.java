public class Main {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add(" /path/to/file", new FileData("File1", (byte) 10, " /path/to/file"));
        fileNavigator.add(" /path/to/file", new FileData("File2", (byte) 12, " /path/to/file"));
        fileNavigator.add(" /anotherPath/to/file", new FileData("File3", (byte) 16, " /anotherPath/to/file"));
        fileNavigator.add(" /anotherPath/to/file", new FileData("File4", (byte) 11, " /anotherPath/to/file"));
        fileNavigator.add(" /thirdPath/to/file", new FileData("File4", (byte) 11, " /thirdPath/to/file"));

        System.out.println(fileNavigator);
        System.out.println(fileNavigator.find(" /path/to/file"));
        System.out.println(fileNavigator.find(" /path/to/file1"));
        System.out.println(fileNavigator.filterBySize((byte) 13));
        System.out.println(fileNavigator.sortBySize());
        fileNavigator.remove(" /thirdPath/to/file");
        System.out.println(fileNavigator);
    }
}
