package com.community.htl.core;

import com.adobe.cq.sightly.WCMUsePojo;
import javax.jcr.Node;

public class HeroTextComponent
        extends WCMUsePojo
{

    /** The hero text bean. */
    private HeroTextBean heroTextBean = null;

    @Override
    public void activate() throws Exception {



        Node currentNode = getResource().adaptTo(Node.class);

        heroTextBean = new HeroTextBean();

        if(currentNode.hasProperty("jcr:Heading")){
            heroTextBean.setHeadingText(currentNode.getProperty("./jcr:Heading").getString());
        }
        if(currentNode.hasProperty("jcr:description")){
            heroTextBean.setDescription(currentNode.getProperty("./jcr:description").getString());
        }

    }



    public HeroTextBean getHeroTextBean() {
        return this.heroTextBean;
    }
}
