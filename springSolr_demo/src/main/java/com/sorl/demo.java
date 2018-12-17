package com.sorl;

import com.pyg.pojo.TbItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-solr.xml")
public class demo {
    @Autowired
    private SolrTemplate solrTemplate;

    @Test
    public void testAdd(){
        TbItem item=new TbItem();
        item.setId(1L);
        item.setBrand("华为");
        item.setCategory("手机");
        item.setGoodsId(1L);
        item.setSeller("华为2号专卖店");
        item.setTitle("华为Mate9");
        item.setPrice(new BigDecimal(2000));

        solrTemplate.saveBean(item);
        solrTemplate.commit();
    }


    @Test
    public void testFindOne(){
        TbItem item=solrTemplate.getById(1,TbItem.class);
        System.out.println(item.getTitle());
    }

    @Test
    public void testDeleteById(){
        solrTemplate.deleteById("1");
        solrTemplate.commit();
    }

    @Test
    public void testAddlist(){
        List<TbItem> itemList=new ArrayList<TbItem>();

        for(int i=0;i<100;i++){
          TbItem item=new TbItem();


            item.setId((long)i);
            item.setBrand("华为");
            item.setCategory("手机");
            item.setGoodsId(1L);
            item.setSeller("华为2号专卖店");
            item.setTitle("华为Mate"+i);
            item.setPrice(new BigDecimal(2000+i));
            itemList.add(item);
        }

        solrTemplate.saveBeans(itemList);
        solrTemplate.commit();
    }

    //分页测试查询
    @Test
    public  void testPageQuery(){
        Query query=new SimpleQuery("*:*");
        query.setOffset(15);
        query.setRows(10);
        ScoredPage<TbItem> tbItems = solrTemplate.queryForPage(query, TbItem.class);
        System.out.println("总记录数："+tbItems.getTotalElements());
        List<TbItem> itemList = tbItems.getContent();

        for (TbItem item : itemList) {
            System.out.println(item.getTitle()+"  "+item.getPrice());
        }

    }

    //条件查询
    @Test
    public void testSearch(){
        Query query=new SimpleQuery("*:*");
        Criteria criteria=new Criteria("item_title").contains("2");
        criteria=criteria.and("item_title").contains("5");
        query.addCriteria(criteria);
        ScoredPage<TbItem> tbItems = solrTemplate.queryForPage(query, TbItem.class);
        System.out.println("总记录数："+tbItems.getTotalElements());
        List<TbItem> tbItemList = tbItems.getContent();
        for (TbItem item : tbItemList) {
            System.out.println(item.getTitle()+" "+item.getPrice());
        }
    }

    @Test
    public void dele(){
        Query query=new SimpleQuery("*:*");
        solrTemplate.delete(query);
        solrTemplate.commit();
    }
}
