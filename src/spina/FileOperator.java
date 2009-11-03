////////////////////////////////////////////////////////////////////////
// FileOperator.java: file system access class
//
// version: 1.0
// author: Yehong Wang (ywang50@syr.edu)
// language: Java 1.6.0.0
////////////////////////////////////////////////////////////////////////

package spina;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

/**
 *
 * @author Yehong
 */
public class FileOperator {

    private FileInputStream fis;
    private DataInputStream in;
    private FileOutputStream fos;
    private DataOutputStream out;
    private PrintStream ps;
    private BufferedReader br;
    private BufferedWriter bw;
    private FileOperatorType mType;

    public enum FileOperatorType { File_Reader, File_Writer, IO_Redirector };

    public FileOperator(File file, FileOperatorType type) {
        try {
            this.mType = type;
            if (type == FileOperatorType.File_Reader) {
                fis = new FileInputStream(file);
                in = new DataInputStream(fis);
                br = new BufferedReader(new InputStreamReader(in));
            }
            else if (type == FileOperatorType.File_Writer) {
                fos = new FileOutputStream(file);
                out = new DataOutputStream(fos);
                bw = new BufferedWriter(new OutputStreamWriter(out));
            }
            else if (type == FileOperatorType.IO_Redirector) {
                fos = new FileOutputStream(file);
                ps = new PrintStream(fos);
                fis = new FileInputStream(file);
                in = new DataInputStream(fis);
                br = new BufferedReader(new InputStreamReader(in));
            }
            else {
                throw new Exception("File operator type undefined!");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File Not Found Error: ");
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Close() {
        try {
            if (mType == FileOperatorType.File_Reader) {
                br.close();
                fis.close();
            }
            else if (mType == FileOperatorType.File_Writer) {
                bw.close();
                fos.close();
            }
            else if (mType == FileOperatorType.IO_Redirector) {
                System.setOut(System.out);
                ps.close();
                fos.close();
                br.close();
                fis.close();
            }
            else {
                throw new Exception("File operator type undefined!");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String ReadLine() {
        try {
            if (this.mType == FileOperatorType.File_Reader || this.mType == FileOperatorType.IO_Redirector)
                return br.readLine();
            else
                return null;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean Save(String content) {
        try {
            if (this.mType == FileOperatorType.File_Writer) {
                bw.write(content);
                return true;
            }
            else
                return false;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void StartOutputRedirection() {
        if (this.mType == FileOperatorType.IO_Redirector)
            System.setOut(ps);
    }

}
