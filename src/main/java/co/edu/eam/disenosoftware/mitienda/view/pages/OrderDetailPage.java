package co.edu.eam.disenosoftware.mitienda.view.pages;

import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.util.LocalStorage;
import co.edu.eam.disenosoftware.mitienda.view.controllers.OrderDetailController;
import co.edu.eam.disenosoftware.mitienda.view.lib.ListView;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.widgets.OrderProductDetailWidget;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * order detail page
 */
public class OrderDetailPage extends Page {

  /**
   * page controller
   */
  private OrderDetailController controller;

  /**
   * order to render
   */
  private Order order;

  public OrderDetailPage() {
    controller = new OrderDetailController();
  }

  @Override
  public void init() throws Exception {
    controller = new OrderDetailController();

    Long orderId = (Long) getParam("orderId");
    orderId = LocalStorage.getData("orderId",Long.class);
    this.order = controller.getOrder(orderId);
  }

  @Override
  public JComponent buildContent() throws Exception {


    List<OrderProduct> orderProducts = order.getProduct();

    //List<OrderProductDetailWidget> productWdgts = new ArrayList<>();
    JPanel panelProducts = new JPanel();
    panelProducts.setLayout(new GridLayout((int)Math.ceil(orderProducts.size() /3),3));

    for(OrderProduct orderProduct: orderProducts) {
      OrderProductDetailWidget wdgt = new OrderProductDetailWidget(orderProduct);
      //productWdgts.add(wdgt);
      panelProducts.add(wdgt);
    }

    //ListView<JComponent> listView = new ListView(productWdgts, ListView.ListViewOrientation.VERTICAL);


    //JScrollPane scrollPane = new JScrollPane();
    return new JScrollPane(panelProducts);

    //return listView;
  }

  @Override
  public JComponent buildHeader() throws Exception {
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(1,1));
    panel.setBackground(Color.GREEN);

    JLabel label = new JLabel("<html><center><b>"+"Order:" + order.getId() + "</b></center></html>");
    label.setPreferredSize(new Dimension(panel.getPreferredSize().width,120));

    label.setAlignmentX(0.5f);

    panel.add(label);
    return panel;
  }


  @Override
  public JComponent buildFooter() throws Exception {
    return null;
  }




}