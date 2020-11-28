package program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TCGAConvertExonID {

	public static void main(String[] args) {
		
		
		try {
			HashMap map = new HashMap();
			String exon_matrix_file = args[0]; // raw input table
			String inputFile = args[1]; // legacy table
			String outputFile = args[2]; // output updated name
			FileInputStream fstream = new FileInputStream(inputFile);
			DataInputStream din = new DataInputStream(fstream);
			BufferedReader in = new BufferedReader(new InputStreamReader(din));
			in.readLine();
			while (in.ready()) {
				String str = in.readLine();
				String[] split = str.split("\t");
				if (!split[0].equals("NA")) {
					map.put(split[0], split[3] + "_" + split[4]);
				}
				if (!split[1].equals("NA")) {
					map.put(split[1], split[3] + "_" + split[4]);
				}
			}
			in.close();
			
			//String outputFile = "Z:\\ResearchHome\\ProjectSpace\\zhanggrp\\AltSpliceAtlas\\common\\analysis\\TCGA_Reference\\RPKM\\legacy\\TCGA_FN1_ED-B_RPKM_sampleName.20190928.txt";
			
			FileWriter fwriter = new FileWriter(outputFile);
			BufferedWriter out = new BufferedWriter(fwriter);
			
			
			int count = 0;
			int count_total = 0;
			//String exon_matrix_file = "Z:\\ResearchHome\\ProjectSpace\\zhanggrp\\AltSpliceAtlas\\common\\analysis\\TCGA_Reference\\RPKM\\legacy\\TCGA_FN1_ED-B_RPKM.20190201.txt";
			
			fstream = new FileInputStream(exon_matrix_file);
			din = new DataInputStream(fstream);
			in = new BufferedReader(new InputStreamReader(din));
			String header = in.readLine();
			out.write(header + "\n");
			String[] split_header = header.split("\t");			
			while (in.ready()) {
				String str = in.readLine();
				String[] split = str.split("\t");
				String name = split[0];
				if (map.containsKey(name)) {
					
					String updated_name = (String)map.get(name);
					if (updated_name.contains("-")) {
						String[] split1 = updated_name.split("-");
						if (split1.length >= 3) {
							count++;
							out.write(split1[0] + "-" + split1[1] + "-" + split1[2] + "-" + split1[3] + "\t" + split[1] + "\t" + split[2] + "\n");
						}
					}
					//out.write(updated_name + "\t" + split[1] + "\t" + split[2] + "\n");
				}
				count_total++;
				
			}
			in.close();
			out.close();
			System.out.println(count + "\t" + count_total);
			
			/*
			//String outputFile = "Z:\\ResearchHome\\ProjectSpace\\zhanggrp\\AltSpliceAtlas\\common\\analysis\\TCGA_Reference\\RPKM\\legacy\\TCGA_FN1_ED-B_RPKM_final_sampleList_20191010_updated.txt";
			String outputFile = "Z:\\ResearchHome\\ProjectSpace\\zhanggrp\\AltSpliceAtlas\\common\\analysis\\TCGA_Reference\\RPKM\\legacy\\TCGA_FN1_ED-B_RPKM.sampleName.20191010_updated.txt";
			FileWriter fwriter = new FileWriter(outputFile);
			BufferedWriter out = new BufferedWriter(fwriter);
			
			String inputFile = "Z:\\ResearchHome\\ProjectSpace\\zhanggrp\\AltSpliceAtlas\\common\\analysis\\TCGA_Reference\\RPKM\\legacy\\TCGA_FN1_ED-B_RPKM.sampleName.20191010.txt";
			FileInputStream fstream = new FileInputStream(inputFile);
			DataInputStream din = new DataInputStream(fstream);
			BufferedReader in = new BufferedReader(new InputStreamReader(din));
			out.write(in.readLine() + "\n");
			while (in.ready()) {
				String str = in.readLine();
				String[] split = str.split("\t");
				if (split[0].contains("-")) {
					String[] split1 = split[0].split("-");
					if (split1.length >= 3) {
						out.write(split1[0] + "-" + split1[1] + "-" + split1[2] + "-" + split1[3] + "\t" + split[1] + "\t" + split[2] + "\n");
					}
				}
			}
			out.close();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

