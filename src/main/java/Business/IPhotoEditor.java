package Business;

public interface IPhotoEditor {
    Object applyFilter(Filter filter, Object source);
    Object applyOperation(Operation operation, Object source); //flip, rotate
    Object adjustColor(ColorParameter colorParameter);
    void loadImage(String path);
    void saveImage(String format);
}
