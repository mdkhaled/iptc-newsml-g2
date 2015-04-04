package iptc.newsml.g2.functional;

import static iptc.common.builder.CalendarBuilder.*;
import static iptc.newsml.g2.builder.CatalogRefBuilder.*;
import static iptc.newsml.g2.builder.ContentMetaBuilder.*;
import static iptc.newsml.g2.builder.ItemMetaBuilder.*;
import static iptc.newsml.g2.builder.NewsItemBuilder.*;
import static iptc.newsml.g2.builder.QcodeBuilder.*;
import static iptc.newsml.g2.builder.AuthorBuilder.*;
import iptc.common.xml.NewsMLG2;
import iptc.newsml.g2.builder.AuthorBuilder;
import iptc.newsml.g2.builder.ContentMetaBuilder;
import iptc.newsml.g2.builder.ItemMetaBuilder;
import iptc.newsml.g2.builder.NewsItemBuilder;

import java.io.StringWriter;

import org.junit.Test;

public class NewsItemFunctional
{

    @Test
    public void testNewsItem() throws Exception
    {
        NewsItemBuilder newsItem = newsItem();

        newsItem.guid("urn:newsml:acmenews.com:20141121:US-FINANCE-FED").version(1);
        newsItem.standardversion("2.19").standard("NewsML-G2").conformance("Power");

        newsItem.addCatalogRef(catalogRef().href("http://www.iptc.org/std/catalog/catalog.IPTC-G2-Standards_25.xml"));
        newsItem.addCatalogRef(catalogRef().href("http://www.example.com/newsml-g2/catalog.enews_2.xml"));
        newsItem.lang("de");

        ItemMetaBuilder itemMeta = itemMeta();
        itemMeta.itemClass(qcode().qcode("ninat:text"));
        itemMeta.versionCreated(calendar().date("2015-01-14"));
        itemMeta.contentModified(calendar().date("2015-01-15"));

        itemMeta.embargoed(calendar().date("2015-01-15"));
        itemMeta.pubStatus(qcode().pubStatusUsable());
        itemMeta.service(qcode().qcode("srv:finance"));
        // TODO add support edNote
        // TODO add support signal
        // TODO add support link
        newsItem.itemMeta(itemMeta);

        ContentMetaBuilder contentMetadata = contentMetadata();
        contentMetadata.contentCreated(calendar().date("2015-01-15"));
        contentMetadata.contentModified(calendar().date("2015-01-15"));
        contentMetadata.urgency(2);
        contentMetadata.creator(creator().uri("http://www.example.com/staff/mjameson"));
        contentMetadata.contributor(contributor().uri("http://www.example.com/staff/mjameson"));

        newsItem.contentMeta(contentMetadata);

        StringWriter writer = new StringWriter();
        NewsMLG2.aProcessor().toXml(newsItem.build(), writer);

        System.out.println(writer);
    }
}
