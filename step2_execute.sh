
java -classpath . program.ExtractLegacyTCGARPKM data_example BCRA_FN1_ED-B_RPKM_raw.txt

java -classpath . program.TCGAConvertExonID BCRA_FN1_ED-B_RPKM_raw.txt legacy_sample_meta_informaion_table.txt BRCA_FN1_ED-B_RPKM_tcga_id.txt

## download the data folder from /// and run the following script.
#java -classpath . program.ExtractLegacyTCGARPKM data tcga_id_conversion.txt TCGA_FN1_ED-B_RPKM_raw.txt TCGA_FN1_ED-B_RPKM_tcga_id.txt

#java -classpath . program.TCGAConvertExonID TCGA_FN1_ED-B_RPKM_raw.txt legacy_sample_meta_informaion_table.txt TCGA_FN1_ED-B_RPKM_tcga_id.txt
