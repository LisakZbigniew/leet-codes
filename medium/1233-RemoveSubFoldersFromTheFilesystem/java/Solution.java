class Solution {

    public List<String> removeSubfolders(String[] folder) {
        Set<String> output = new HashSet<String>();
        Folder root = new Folder();
        Arrays.sort(folder);
        for(String dir : folder){
            if(dir.equals("/")){
                return List.of("/");
            }
            String[] dirPath = dir.split("/");
            root.add(dirPath,0,"",output);
        }
        return new ArrayList<String>(output);
    }

    class Folder {
        Map<String,Folder> subFolders = new HashMap<>();
        public boolean isInList = false;

        public void add(String[] fullPath, int currIndexInPath,String currentPath,Set<String> out){
            if(currIndexInPath == fullPath.length - 1){
                this.isInList = true;
            }
            if(isInList){
                out.add(currentPath);
                return;
            }
            String nextStep = fullPath[currIndexInPath + 1];
            if(!subFolders.containsKey(nextStep)){
                subFolders.put(nextStep,new Folder());
            }
            subFolders.get(nextStep).add(fullPath,currIndexInPath + 1, currentPath + "/" + nextStep, out);
        }

    }
}