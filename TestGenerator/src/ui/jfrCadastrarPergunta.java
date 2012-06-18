/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import contracts.IMateria;
import contracts.IPergunta;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Materia;
import models.Nivel;
import models.Pergunta;
import models.Resposta;
import repository.MateriaRepository;
import repository.PerguntaRepository;

/**
 *
 * @author Facensa
 */
public class jfrCadastrarPergunta extends javax.swing.JFrame {
    
    private boolean modoEdição;
    private IMateria srvMateria;
    private IPergunta srvPergunta;
    private int id = 0;
    
    public jfrCadastrarPergunta() {
        initComponents();
        srvMateria = new MateriaRepository();
        srvPergunta = new PerguntaRepository(srvMateria);
        carregarMaterias();
        carregarOptions();
        modoEdição = false;
    }
    
    public jfrCadastrarPergunta(int _id) {
        initComponents();
        srvMateria = new MateriaRepository();
        srvPergunta = new PerguntaRepository(srvMateria);
        Pergunta _pergunta = srvPergunta.BuscarPergunta(_id);
        id = _id;
        modoEdição = true;
        carregarOptions(); 
        carregarMaterias(_pergunta);               
        carregarNiveis(_pergunta);
        carregarPergunta();
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
        pnlPerguntas = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtResposta4 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtResposta3 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtResposta2 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResposta1 = new javax.swing.JTextArea();
        rdbOpcao1 = new javax.swing.JRadioButton();
        rdbOpcao2 = new javax.swing.JRadioButton();
        rdbOpcao3 = new javax.swing.JRadioButton();
        rdbOpcao4 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPergunta = new javax.swing.JTextArea();

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

        pnlPerguntas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Respostas", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        txtResposta4.setColumns(20);
        txtResposta4.setRows(5);
        jScrollPane5.setViewportView(txtResposta4);

        txtResposta3.setColumns(20);
        txtResposta3.setRows(5);
        jScrollPane4.setViewportView(txtResposta3);

        txtResposta2.setColumns(20);
        txtResposta2.setRows(5);
        jScrollPane3.setViewportView(txtResposta2);

        txtResposta1.setColumns(20);
        txtResposta1.setRows(5);
        jScrollPane2.setViewportView(txtResposta1);

        javax.swing.GroupLayout pnlPerguntasLayout = new javax.swing.GroupLayout(pnlPerguntas);
        pnlPerguntas.setLayout(pnlPerguntasLayout);
        pnlPerguntasLayout.setHorizontalGroup(
            pnlPerguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPerguntasLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlPerguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rdbOpcao1)
                    .addComponent(rdbOpcao2)
                    .addComponent(rdbOpcao3)
                    .addComponent(rdbOpcao4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPerguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        pnlPerguntasLayout.setVerticalGroup(
            pnlPerguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPerguntasLayout.createSequentialGroup()
                .addGroup(pnlPerguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPerguntasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPerguntasLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(rdbOpcao1)))
                .addGroup(pnlPerguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPerguntasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPerguntasLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(rdbOpcao2)))
                .addGroup(pnlPerguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPerguntasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPerguntasLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(rdbOpcao3)))
                .addGroup(pnlPerguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPerguntasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPerguntasLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(rdbOpcao4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtPergunta.setColumns(20);
        txtPergunta.setRows(5);
        jScrollPane1.setViewportView(txtPergunta);

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
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnVoltar)))
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPerguntas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPerguntas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
            
    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (validarCampos()) {
            
            String descricao = txtPergunta.getText();                                               
            Materia materia = (Materia)cboMaterias.getSelectedItem();            
            String _nivel = cboNivel.getSelectedItem().toString();
            Nivel nivel = Nivel.RetornaNivel(_nivel);                                    
            Pergunta pergunta = new Pergunta(materia, descricao, nivel);
            
            pergunta.AdicionarResposta(new Resposta(txtResposta1.getText(),
                                              rdbOpcao1.isSelected()));            
            pergunta.AdicionarResposta(new Resposta(txtResposta2.getText(),
                                              rdbOpcao2.isSelected()));
            pergunta.AdicionarResposta(new Resposta(txtResposta3.getText(),
                                              rdbOpcao3.isSelected()));
            pergunta.AdicionarResposta(new Resposta(txtResposta4.getText(),
                                              rdbOpcao4.isSelected()));
            
            if (modoEdição) 
                srvPergunta.AlterarPergunta(id, pergunta);
            else
                srvPergunta.SalvarPergunta(pergunta);
            
            JOptionPane.showMessageDialog(null, "Pergunta salva com sucesso!");
            this.setVisible(false);
            this.disable();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed
    
    private void carregarPergunta()
    {
        Pergunta pergunta = srvPergunta.BuscarPergunta(id);
        
        txtPergunta.setText(pergunta.Descricao());
                     
        ArrayList<Resposta> respostas = pergunta.BuscarRespostas();
        Resposta resposta1 = respostas.get(0);
        Resposta resposta2 = respostas.get(1);
        Resposta resposta3 = respostas.get(2);
        Resposta resposta4 = respostas.get(3);
        
        txtResposta1.setText(resposta1.Descricao());        
        rdbOpcao1.setSelected(resposta1.Correta());        
        txtResposta2.setText(resposta2.Descricao());
        rdbOpcao2.setSelected(resposta2.Correta());        
        txtResposta3.setText(resposta3.Descricao());
        rdbOpcao3.setSelected(resposta3.Correta());        
        txtResposta4.setText(resposta4.Descricao());
        rdbOpcao4.setSelected(resposta4.Correta());
        
    }
    
    private void carregarOptions() {
        btnGroupOpcoes.add(rdbOpcao1);
        btnGroupOpcoes.add(rdbOpcao2);
        btnGroupOpcoes.add(rdbOpcao3);
        btnGroupOpcoes.add(rdbOpcao4);
    }
    
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
    
    private void carregarMaterias(Pergunta pergunta)
    {                
        ArrayList<Materia> materias = srvMateria.BuscarMaterias();
        
        for(Materia materia : materias)
        {
            cboMaterias.addItem(materia);  
            if (pergunta != null) {                
                if (materia.Descricao().equals(pergunta.Materia().Descricao())) {
                    cboMaterias.setSelectedItem(materia);
                }
            }
        }
    }
    
    private void carregarNiveis(Pergunta pergunta)
    {                
        String nivel = pergunta.Nivel().toString();
        
        switch(nivel)
        {
            case "facil": 
                popularNiveis(0);
                break;
            case "medio": 
                popularNiveis(1);
                break;
            case "dificil": 
                popularNiveis(2);
                break;
        }        
    }
    
    private void popularNiveis(int _id)
    {
        cboNivel.removeAllItems();
        cboNivel.addItem("Fácil");
        cboNivel.addItem("Médio"); 
        cboNivel.addItem("Difícil"); 
        cboNivel.setSelectedIndex(_id);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel pnlPerguntas;
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
