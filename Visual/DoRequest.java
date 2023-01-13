/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Back.Cliente;
import Back.Libro;
import Back.Pedido;
import Back.Sala;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel Mesa
 */
public class DoRequest extends javax.swing.JFrame {

    ClientePage caller;
    Cliente c;
    List<Libro> list;
            
    public DoRequest(ClientePage call, Cliente c) {
        this.c = c;
        caller = call;
        initComponents();
        actualizarListaSalas();
        actulizarListaMaterias(null);
        actualizarTabla();
    }

    private void actualizarListaSalas() {
        List<Sala> s = MainFrame.feria.get_lista_salas();
        SalaCombo.removeAllItems();
        SalaCombo.addItem("Ninguna");
        for(Sala x : s){
            SalaCombo.addItem(x.toString());
        }
    }
    
    private void actulizarListaMaterias(Sala sa) {
        List<String> s;
        if(sa == null){
            s = MainFrame.feria.getListaMaterias();
        }else{
            s = sa.getListaMaterias();
        }
        MateriaCombo.removeAllItems();
        MateriaCombo.addItem("Ninguna");
        for(String x : s){
            MateriaCombo.addItem(x);
        }
    }
    
    private void actualizarTabla(){
        if(SalaCombo.getSelectedIndex() == 0){
            if(MateriaCombo.getSelectedIndex() == 0) {
                list = MainFrame.feria.getLibros();
            }else{
                String materia = (String) MateriaCombo.getSelectedItem();
                list = MainFrame.feria.getLibrosMateria(materia);
            }
        }else{
            Sala selected = (Sala) SalaCombo.getSelectedItem();
            if(MateriaCombo.getSelectedIndex() == 0){
                list = selected.get_lista_de_libros();
            }else{
                String materia = (String) MateriaCombo.getSelectedItem();
                list = selected.getListaPorMateria(materia);
            }
        }
        String[] columnNames = {"Titulo", "Autor", "Sinopsis", "Precio"};
        String[][] data = new String[list.size()][4];
        int i=0;
        for(Libro c : list){
            data[i][0] = c.getTitulo();
            data[i][1] = c.getAutor();
            data[i][2] = c.getSinopsis();
            data[i][3] = Double.toString(c.getValor());
        }
        
        Tabla.setModel(new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SalaCombo = new javax.swing.JComboBox();
        MateriaCombo = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cantField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Sala:");

        jLabel2.setText("Materia:");

        SalaCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        SalaCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalaComboActionPerformed(evt);
            }
        });

        MateriaCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(Tabla);

        jLabel3.setText("Cantidad a Comprar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(SalaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(239, 239, 239))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cantField))
                                .addComponent(jButton2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MateriaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(SalaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(MateriaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cantField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void SalaComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalaComboActionPerformed
        if(SalaCombo.getSelectedIndex() == 0){
            actulizarListaMaterias(null);
        }else{
            Sala sal = (Sala) SalaCombo.getSelectedItem();
            actulizarListaMaterias(sal);
        }
    }//GEN-LAST:event_SalaComboActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int a =  Tabla.getSelectedRow();
        if(a<0){
            JOptionPane.showMessageDialog(MateriaCombo, "Debe seleccionar un libro");
            return;
        }
        Libro lib = list.get(a);
        int b = Integer.parseInt(cantField.getText());
        if( b <= lib.getCantidad() && b > 0 ){
            c.add_Pedido(new Pedido( lib, b ));
            lib.setCantidad(lib.getCantidad()-b);
        }else{
            JOptionPane.showMessageDialog(MateriaCombo, "La cantidad seleccionada debe ser menor o igual a la cantidad de libros");
        }
        caller.actualizarLista();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox MateriaCombo;
    private javax.swing.JComboBox SalaCombo;
    private javax.swing.JTable Tabla;
    private javax.swing.JTextField cantField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
