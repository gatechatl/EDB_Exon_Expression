library(ggplot2);
options(bitmapType='cairo')
data = read.table("TCGA_FN1_ED-B_RPKM.sampleName.20200312_updated.txt", sep="\t",header=T);
p1 = ggplot(data, aes(factor(CancerName), log2(RPKM + 1), fill=CancerName)) + geom_boxplot(width=0.5, lwd=1.5, fill="white") + ggtitle("EDB RPKM") + theme(plot.title=element_text(size=10), axis.text.x = element_text(size=10, angle=45), axis.text.y = element_text(size=10), axis.title = element_text(size=10), legend.text = element_text(size=10), legend.title = element_text(size=10)) + theme_bw() + coord_flip();
#+ ylim(0, 1000);
png(file = "EDB.txt.png", width=2000,height=1500, res=200)
p1
dev.off();


