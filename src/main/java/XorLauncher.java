import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class XorLauncher {

    @Option(name = "-c", metaVar = "Code", forbids = {"-d"}, usage = "Code file")
    private String key1;

    @Option(name = "-d", metaVar = "Decode", forbids = {"-c"}, usage = "Decode file")
    private String key2;

    @Argument(required = true, metaVar = "InputName", usage = "Input file name")
    private String inputFileName;

    @Option(name = "-o", required = true, metaVar = "OutputName", usage = "Output file name")
    private String outputFileName;

    public static void main(String[] args) {
        new XorLauncher().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("ciphxor [-c|-d] key InputName -o OutputName");
            parser.printUsage(System.err);
            return;
        }
        String key;
        if (key1 == null) key = key2;
        else key = key1;
        Xor launcher = new Xor();
        launcher.ciphxor(key, inputFileName, outputFileName);
    }
}