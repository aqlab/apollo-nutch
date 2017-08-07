package com.spy.apollo.nutch;

import lombok.extern.slf4j.Slf4j;
import org.apache.nutch.crawl.DbUpdaterJob;
import org.apache.nutch.crawl.GeneratorJob;
import org.apache.nutch.crawl.InjectorJob;
import org.apache.nutch.fetcher.FetcherJob;
import org.apache.nutch.parse.ParserJob;
import org.junit.Test;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @version 1.0 2017-08-07 10:08
 * @since 1.0
 */
@Slf4j
public class NutchTest {

    @Test
    public void allFlowTest() throws Exception {
        String crawlId = "20170807";

        GeneratorJob gen = new GeneratorJob();

        try {
            String[] arg1 = {"c:/urls.txt", "-crawlId", crawlId};
            InjectorJob.main(arg1);

            for (int count = 0; count < 2; count++) {
                String[] arg2 = {"-crawlId", crawlId};
                //String a = gen.gen(arg2);
                //System.out.println("输出的是" + a);
                //String[] arg3 = {a, "-crawlId", crawlId};

                String[] arg3 = {"-crawlId", crawlId};
                FetcherJob.main(arg3);
                ParserJob.main(arg3);
                DbUpdaterJob.main(arg3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
