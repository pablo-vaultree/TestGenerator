package ui;

import contracts.IMateria;
import contracts.IPergunta;
import contracts.IProva;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Materia;
import models.Nivel;
import models.Prova;
import repository.MateriaRepository;
import repository.PerguntaRepository;
import repository.ProvaRepository;

/**
 *
 * @author pablo.feijo
 */
public class jfrCadastrarProva extends javax.swing.JFrame {
    
    IMateria srvMateria;
    IPergunta srvPergunta;
    IProva srvProva;
        
    public jfrCadastrarProva() {
        initComponents();
        setLocationRelativeTo(null);
        
        srvMateria = new MateriaRepository();
        srvPergunta = new PerguntaRepository(srvMateria);
        srvProva = new ProvaRepository(srvPergunta);
        carregarMaterias();
        carregarNiveis();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboMaterias = new javax.swing.JComboBox();
        cboNiveis = new javax.swing.JComboBox();
        txtProfessor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnGerarProva = new javax.swing.JButton();
        txtData = new javax.swing.JFormattedTextField();
        txtQtd = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Prova");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Gerar Prova");

        cboNiveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNiveisActionPerformed(evt);
            }
        });

        jLabel2.setText("Materia:");

        jLabel3.setText("Nivel:");

        jLabel4.setText("Nome Professor:");

        jLabel5.setText("Data da Prova:");

        btnGerarProva.setText("Gerar Prova");
        btnGerarProva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarProvaActionPerformed(evt);
            }
        });

        txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        txtQtd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel6.setText("Qtd de Perguntas:");

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboNiveis, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(btnGerarProva)
                        .addGap(18, 18, 18)
                        .addComponent(btnVoltar)))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboNiveis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGerarProva)
                    .addComponent(btnVoltar))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerarProvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarProvaActionPerformed
        if (this.ValidarCampos()) {
            
            String professor = txtProfessor.getText();                                               
            String data = txtData.getText();                                               
            int qtd = Integer.parseInt(txtQtd.getText());                                               
            Materia materia = (Materia)cboMaterias.getSelectedItem();            
            String _nivel = cboNiveis.getSelectedItem().toString();
            Nivel nivel = Nivel.RetornaNivel(_nivel);         
            
            Prova prova = srvProva.GerarProva(professor, materia, nivel, data, qtd);
            
            if (prova == null) {
                JOptionPane.showMessageDialog(null, "Nenhuma pergunta foi encontrada para o filtro aplicado!");                
                return;
            }
            
            if (prova.BuscarPerguntas().size() != qtd) {
                String msg = String.format("O filtro encoutro apenas %s pergunta(s)", Integer.toString(prova.BuscarPerguntas().size()));
                JOptionPane.showMessageDialog(null, msg);                
            }
            
            new jfrVisualizarProva(prova, true).setVisible(true); 
            this.setVisible(false);
            this.dispose();
        }
    }//GEN-LAST:event_btnGerarProvaActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.setVisible(false);
        new jfrListarProvas().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void cboNiveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNiveisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNiveisActionPerformed
    
    private Boolean ValidarCampos()
    {
                
        if (txtProfessor.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe o nome do professor!");
            return false;
        }
        
        if (txtData.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe a data da prova!");
            return false;
        }
        
        if (txtQtd.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe a quantidade de perguntas!");
            return false;
        }else if(txtQtd.getText().equals("0"))
        {
            JOptionPane.showMessageDialog(null, "Informe um número maior que 0 para a quantidade de perguntas!");
            return false;
        }        
        
        return true;
    }   
    
    private void carregarMaterias()
    {
        ArrayList<Materia> materias = srvMateria.BuscarMaterias();
        for(Materia materia : materias)
        {
            cboMaterias.addItem(materia);            
        }
    }
    
    private void carregarNiveis()
    {        
        cboNiveis.addItem("Fácil");
        cboNiveis.addItem("Médio"); 
        cboNiveis.addItem("Difícil");         
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfrCadastrarProva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrCadastrarProva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrCadastrarProva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrCadastrarProva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new jfrCadastrarProva().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarProva;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cboMaterias;
    private javax.swing.JComboBox cboNiveis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtProfessor;
    private javax.swing.JFormattedTextField txtQtd;
    // End of variables declaration//GEN-END:variables
}
