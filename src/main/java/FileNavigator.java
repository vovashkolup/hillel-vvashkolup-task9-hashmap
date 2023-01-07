import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class FileNavigator {
    private HashMap<String, ArrayList<FileData>> fileDataHashMap = new HashMap<>();

    @Override
    public String toString() {
        return "FileNavigator{" +
                "fileDataHashMap="+"\n"+ fileDataHashMap+
                '}';
    }

    public FileNavigator(HashMap<String, ArrayList<FileData>> fileDataHashMap) {
        this.fileDataHashMap = fileDataHashMap;
    }

    public FileNavigator() {
    }


    public void add(String path, FileData file) {
        if (fileDataHashMap.containsKey(path)) {
            fileDataHashMap.get(file.getPath()).add(file);
        } else {
            fileDataHashMap.put(path, new ArrayList<>(List.of(file)));
        }
    }

    public String find(String path) {
        if (fileDataHashMap.containsKey(path)) {
            return fileDataHashMap.get(path).toString();
        } else {
            System.out.println("No such pass yet");
            return null;
        }
    }

    public List<FileData> filterBySize(byte aByte) {
        ArrayList<FileData> list = new ArrayList<>();
        for (List<FileData> fileDataList : fileDataHashMap.values()) {
            for (FileData fileData : fileDataList) {
                if (fileData.getSize() <= aByte) {
                    list.add(fileData);
                }
            }
        }
        return list;
    }

    public void remove(String path) {
        fileDataHashMap.remove(path);
    }

    public List<FileData> sortBySize(){
        ArrayList <FileData> arrayList=new ArrayList<>();
        for (ArrayList <FileData> fileData:fileDataHashMap.values()) {
           arrayList.addAll(fileData);
        }
        arrayList.sort(Comparator.comparing(FileData::getSize));
        return arrayList;
    }
}
