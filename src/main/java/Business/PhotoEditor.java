package Business;

public class PhotoEditor implements IPhotoEditor{

    @Override
    public Object applyFilter(Filter filter, Object source) {
        return null;
    }

    @Override
    public Object applyOperation(Operation operation, Object source) {
        return null;
    }

    @Override
    public Object adjustColor(ColorParameter colorParameter) {
        return null;
    }

    @Override
    public void loadImage(String path) {
        System.out.println("hihi load image");
    }

    @Override
    public void saveImage(String format) {

    }
}
