/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import contracts.IMateria;
import contracts.IPergunta;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import models.Materia;
import models.Nivel;
import repository.MateriaRepository;
import repository.PerguntaRepository;

/**
 *
 * @author Facensa
 */
public class jfrCadastrarPergunta extends javax.swing.JFrame {
    
    private int id;
    private IMateria srvMateria;
    private IPergunta srvPergunta;
    
    public jfrCadastrarPergunta() {
        initComponents();
        srvMateria = new MateriaRepository();
        srvPergunta = new PerguntaRepository(srvMateria);
        carregarMaterias();
        carregarOptions();
    }
    
    public jfrCadastrarPergunta(int _id) {
        initComponents();
        id = _id;
        srvMateria = new MateriaRepository();
        srvPergunta = new PerguntaRepository(srvMateria);
        carregarMaterias();
        carregarOptions();
    }
    
                
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupOpcoes = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cboMaterias = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cboNivel = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPergunta = new javax.swing.JTextArea();
        rdbOpcao1 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResposta1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtResposta2 = new javax.swing.JTextArea();
        rdbOpcao2 = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtResposta3 = new javax.swing.JTextArea();
        rdbOpcao3 = new javax.swing.JRadioButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtResposta4 = new javax.swing.JTextArea();
        rdbOpcao4 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Cadastrar Pergunta");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel2.setText("Matéria:");

        jLabel3.setText("Nível:");

        cboNivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fácil", "Médio", "Díficil" }));

        jLabel4.setText("Pergunta");

        txtPergunta.setColumns(20);
        txtPergunta.setRows(5);
        jScrollPane1.setViewportView(txtPergunta);

        txtResposta1.setColumns(20);
        txtResposta1.setRows(5);
        jScrollPane2.setViewportView(txtResposta1);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Respostas:");

        txtResposta2.setColumns(20);
        txtResposta2.setRows(5);
        jScrollPane3.setViewportView(txtResposta2);

        txtResposta3.setColumns(20);
        txtResposta3.setRows(5);
        jScrollPane4.setViewportView(txtResposta3);

        txtResposta4.setColumns(20);
        txtResposta4.setRows(5);
        jScrollPane5.setViewportView(txtResposta4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdbOpcao1)
                                    .addComponent(rdbOpcao2)
                                    .addComponent(rdbOpcao3)
                                    .addComponent(rdbOpcao4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3)
                                    .addComponent(jScrollPane5)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1)))
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnSalvar)
                    .addComponent(btnVoltar))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cboNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(rdbOpcao1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(rdbOpcao2)
                        .addGap(96, 96, 96)
                        .addComponent(rdbOpcao3)
                        .addGap(94, 94, 94)
                        .addComponent(rdbOpcao4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void carregarOptions() {
        btnGroupOpcoes.add(rdbOpcao1);
        btnGroupOpcoes.add(rdbOpcao2);
        btnGroupOpcoes.add(rdbOpcao3);
        btnGroupOpcoes.add(rdbOpcao4);
    }
    
    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (validarCampos()) {
            
            String pergunta = txtPergunta.getText();
                                   
            String text = btnGroupOpcoes.getSelection().toString();
            
            String resposta1 = txtResposta1.getText();
            String resposta2 = txtResposta2.getText();
            String resposta3 = txtResposta3.getText();
            String resposta4 = txtResposta4.getText();
            
            Materia materia = (Materia)cboMaterias.getSelectedItem();
            
            String _nivel = cboNivel.getSelectedItem().toString();
            Nivel nivel = Nivel.RetornaNivel(_nivel);                        
                                    
        }
    }//GEN-LAST:event_btnSalvarActionPerformed
    
    private boolean validarCampos()
    {
        if (txtPergunta.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe a pergunta!");
            return false;
        }
        
        if (txtResposta1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe a primeira resposta!");
            return false;
        }
        
        if (txtResposta2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe a segunda resposta!");
            return false;
        }
        
        if (txtResposta3.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe a terceira resposta!");
            return false;
        }
        
        if (txtResposta4.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe a quarta resposta!");
            return false;
        }
        
        if (btnGroupOpcoes.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Selecione uma reposta como correta!");
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
            java.util.logging.Logger.getLogger(jfrCadastrarPergunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrCadastrarPergunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrCadastrarPergunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrCadastrarPergunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new jfrCadastrarPergunta().setVisible(true);
            }
        });
    }
    
    //<editor-fold defaultstate="collapsed" desc=" variaveis de tela ">        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupOpcoes;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cboMaterias;
    private javax.swing.JComboBox cboNivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JRadioButton rdbOpcao1;
    private javax.swing.JRadioButton rdbOpcao2;
    private javax.swing.JRadioButton rdbOpcao3;
    private javax.swing.JRadioButton rdbOpcao4;
    private javax.swing.JTextArea txtPergunta;
    private javax.swing.JTextArea txtResposta1;
    private javax.swing.JTextArea txtResposta2;
    private javax.swing.JTextArea txtResposta3;
    private javax.swing.JTextArea txtResposta4;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
