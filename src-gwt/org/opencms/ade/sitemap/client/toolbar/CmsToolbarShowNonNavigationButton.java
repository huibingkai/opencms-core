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

package org.opencms.ade.sitemap.client.toolbar;

import org.opencms.ade.sitemap.client.CmsSitemapView;
import org.opencms.ade.sitemap.client.CmsSitemapView.EditorMode;
import org.opencms.ade.sitemap.client.Messages;
import org.opencms.gwt.client.ui.CmsMenuButton;
import org.opencms.gwt.client.ui.I_CmsButton;
import org.opencms.gwt.client.ui.I_CmsButton.Size;
import org.opencms.gwt.client.ui.contextmenu.CmsContextMenu;
import org.opencms.gwt.client.ui.contextmenu.CmsContextMenuCloseHandler;
import org.opencms.gwt.client.ui.contextmenu.I_CmsContextMenuEntry;
import org.opencms.gwt.client.ui.css.I_CmsLayoutBundle;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlexTable;

/**
 * The sitemap toolbar change sitemap editor mode button.<p>
 * 
 * @since 8.0.0
 */
public class CmsToolbarShowNonNavigationButton extends CmsMenuButton {

    /** The context menu entries. */
    private List<I_CmsContextMenuEntry> m_entries;

    /** The main content widget. */
    private FlexTable m_menuPanel;

    /**
     * Constructor.<p>
     */
    public CmsToolbarShowNonNavigationButton() {

        super(null, I_CmsButton.ButtonData.SITEMAP.getIconClass());
        setTitle(Messages.get().key(Messages.GUI_SELECT_VIEW_0));
        m_menuPanel = new FlexTable();
        // set a style name for the menu table
        m_menuPanel.getElement().addClassName(I_CmsLayoutBundle.INSTANCE.contextmenuCss().menuPanel());
        m_button.setSize(Size.small);
        // set the widget
        setMenuWidget(m_menuPanel);
        getPopup().addAutoHidePartner(getElement());
        getPopup().setWidth(0);
        m_entries = new ArrayList<I_CmsContextMenuEntry>();
        m_entries.add(new A_CmsSitemapModeEntry(Messages.get().key(Messages.GUI_ONLY_NAVIGATION_BUTTON_TITLE_0)) {

            public void execute() {

                CmsSitemapView.getInstance().setEditorMode(EditorMode.navigation);
            }
        });
        m_entries.add(new A_CmsSitemapModeEntry(Messages.get().key(Messages.GUI_NON_NAVIGATION_BUTTON_TITLE_0)) {

            public void execute() {

                CmsSitemapView.getInstance().setEditorMode(EditorMode.vfs);
            }
        });
        m_entries.add(new A_CmsSitemapModeEntry(Messages.get().key(Messages.GUI_ONLY_GALLERIES_BUTTON_TITLE_0)) {

            public void execute() {

                CmsSitemapView.getInstance().setEditorMode(EditorMode.galleries);
            }
        });

        CmsContextMenu menu = new CmsContextMenu(m_entries, false, getPopup());
        m_menuPanel.setWidget(0, 0, menu);
        // add the close handler for the menu
        getPopup().addCloseHandler(new CmsContextMenuCloseHandler(menu));
        addClickHandler(new ClickHandler() {

            /**
             * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
             */
            public void onClick(ClickEvent event) {

                if (!isOpen()) {
                    openMenu();
                } else {
                    closeMenu();
                }
            }
        });
    }
}
