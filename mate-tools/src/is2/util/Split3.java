package is2.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.StringTokenizer;

public class Split3 {

	/**
	 * Splits a tokenized sentences into one word per line format:
	 *
	 * Input
	 * > I am an text .
	 * > Sentence two ...
	 * 
	 * Output:
	 * I	_	_	_ 	...
	 * am	_	_	_ 	...
	 * ...
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {

		if (args.length<1) {
			System.out.println("Please provide a file name.");
			System.exit(0);
		}
		
		
	    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]),"UTF-8"),32768);
		BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]),"UTF-8"),32768);
		
	
		String s;
		int cnt=0;
		while ((s = reader.readLine()) != null) {
			StringTokenizer t = new StringTokenizer(s);
			while(t.hasMoreTokens()) {
				String tk =t.nextToken();
				write.write(tk);
				write.newLine();
				cnt++;
			}
			write.newLine();
		}
		reader.close();
		write.flush();
		write.close();
		
		
			
	}
	
	
}
