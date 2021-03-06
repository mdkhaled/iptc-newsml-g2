package iptc.newsml.g2.builder;

/*
 * #%L
 * IPTC NewsML G2 Model
 * %%
 * Copyright (C) 2015 Ben Asmussen <opensource@ben-asmussen.com>
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import static org.junit.Assert.*;
import static iptc.newsml.g2.builder.NewsItemBuilder.*;
import static iptc.newsml.g2.builder.ContentMetaBuilder.*;
import iptc.newsml.g2.model.NewsItem;

import org.junit.Test;

public class NewsItemBuilderTest
{

    @Test
    public void testBuild() throws Exception
    {
        NewsItem newsItem = newsItem().build();
        assertNotNull(newsItem);
    }

    @Test
    public void testGetContentMeta() throws Exception
    {
        NewsItem newsItem = newsItem().contentMeta(contentMetadata()).build();
        assertNotNull(newsItem.getContentMeta());
    }

}
