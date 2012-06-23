package ui;

import contracts.IMateria;
import contracts.IPergunta;
import contracts.IProva;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import models.Prova;
import repository.MateriaRepository;
import repository.PerguntaRepository;
import repository.ProvaRepository;

/**
 *
 * @author pablo.feijo
 */
public class jfrListarProvas extends javax.swing.JFrame {

    IMateria srvMateria;
    IPergunta srvPergunta;
    IProva srvProva;
    
    public jfrListarProvas() {
        initComponents();
        setLocationRelativeTo(null);
        
        srvMateria = new MateriaRepository();
        srvPergunta = new PerguntaRepository(srvMateria);
        srvProva = new ProvaRepository(srvPergunta);
        this.CarregarProvas();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnNova = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstProvas = new javax.swing.JList();
        btnExcluir = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();
        btnVisualizar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Prova");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                CarregarProvas(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Provas");

        btnNova.setText("Nova");
        btnNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstProvas);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnVisualizar.setText("Visualizar Prova");
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        btnVisualizar1.setText("Visualizar Gabarito");
        btnVisualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNova)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVisualizar)
                .addGap(15, 15, 15)
                .addComponent(btnVisualizar1)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNova)
                            .addComponent(btnVoltar))))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnVisualizar)
                    .addComponent(btnVisualizar1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaActionPerformed
        new jfrCadastrarProva().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNovaActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.setVisible(false);
        new jfrInicio().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        if (lstProvas.getSelectedIndex() != -1) {            
            String str[] = lstProvas.getSelectedValue().toString().split("-");
            int id = Integer.parseInt(str[0].trim());                     
            new jfrVisualizarProva(id, false).setVisible(true);
            this.dispose();
        }                
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (lstProvas.getSelectedIndex() != -1) {            
            String str[] = lstProvas.getSelectedValue().toString().split("-");
            int id = Integer.parseInt(str[0].trim());
            Prova prova = srvProva.BuscarProva(id);            
            srvProva.ExcluirProva(prova);
            this.CarregarProvas();
            JOptionPane.showMessageDialog(null, "Prova excluida com sucesso!"); 
        }                
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void CarregarProvas(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_CarregarProvas
        this.CarregarProvas();
    }//GEN-LAST:event_CarregarProvas

    private void btnVisualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizar1ActionPerformed
        if (lstProvas.getSelectedIndex() != -1) {            
            String str[] = lstProvas.getSelectedValue().toString().split("-");
            int id = Integer.parseInt(str[0].trim());                     
            new jfrVisualizarProva(id, true).setVisible(true);
            this.dispose();
        }    
    }//GEN-LAST:event_btnVisualizar1ActionPerformed
    
     private void CarregarProvas()
    {    
        DefaultListModel model = new DefaultListModel();
        model.clear();
        lstProvas.setModel(model);
        
        ArrayList<Prova> provas = srvProva.BuscarProvas();                        
        
        for (Prova prova : provas) {            
            String id = Integer.toString(prova.Id());
            String professor = prova.NomeProfessor();
            String materia = prova.Materia().toString();
            String data = prova.Data();
            String text = String.format("%s - %s - %s - %s", id, professor, materia, data);
            model.addElement(text);            
        }
        
        lstProvas.setModel(model);   
    }
   
    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrListarProvas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new jfrListarProvas().setVisible(true);
            }
        });
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Variables declaration - do not modify   ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNova;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JButton btnVisualizar1;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstProvas;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
