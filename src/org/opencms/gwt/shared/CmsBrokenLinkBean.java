/*
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (c) Alkacon Software GmbH (http://www.alkacon.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.opencms.gwt.shared;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * A bean which represents either the source or the target of a broken link.<p>
 * 
 * @since 8.0.0
 */
public class CmsBrokenLinkBean implements IsSerializable {

    /** The child beans (usually represent link targets). */
    private List<CmsBrokenLinkBean> m_children = new ArrayList<CmsBrokenLinkBean>();

    /** The title. */
    private String m_subtitle;

    /** The subtitle. */
    private String m_title;

    /** The resource type. */
    private String m_type;

    /**
     * Constructor without a type parameter.<p>
     * 
     * @param title the title 
     * @param subtitle the subtitle 
     */
    public CmsBrokenLinkBean(String title, String subtitle) {

        this(title, subtitle, null);
    }

    /**
     * Constructor.<p>
     * @param title the title 
     * @param subtitle the subtitle
     * @param type the resource type  
     */
    public CmsBrokenLinkBean(String title, String subtitle, String type) {

        m_title = title;
        m_subtitle = subtitle;
        m_type = type;
    }

    /**
     * Hidden default constructor.<p>
     */
    protected CmsBrokenLinkBean() {

        // do nothing
    }

    /**
     * Adds a child bean to this bean.<p>
     * 
     * The child usually represents a link target.<p>
     * 
     * @param bean the bean to add as a sub-bean 
     */
    public void addChild(CmsBrokenLinkBean bean) {

        getChildren().add(bean);
    }

    /**
     * Returns the child beans of this bean.<p>
     * 
     * @return the list of child beans 
     */
    public List<CmsBrokenLinkBean> getChildren() {

        return m_children;
    }

    /**
     * Returns the sub-title of the bean.<p>
     * 
     * @return the sub-title 
     */
    public String getSubTitle() {

        return m_subtitle;

    }

    /**
     * Returns the title of the bean.<p>
     * 
     * @return the title of the bean
     */
    public String getTitle() {

        return m_title;
    }

    /**
     * Returns the resource type.<p>
     * 
     * @return the resource type 
     */
    public String getType() {

        return m_type;
    }

}
