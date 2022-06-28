public abstract class File {
    protected String name;

    public File(String name) {
        this.name = name;
    }

    public int dotsQty(){
        return 0;
    }

    public int numberOfWords(){
        return 0;
    }

    public String mostRepeatedWord(){
        return "";
    }

}
