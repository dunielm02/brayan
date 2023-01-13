package Visual;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Daniel Mesa
 */
class CCFFileFilter extends FileFilter {
    @Override
    public boolean accept(File file) {
        return file.isDirectory() || file.getName().endsWith(".dat");
    }

    @Override
    public String getDescription() {
        return "Archivos dat";
    }    
}
