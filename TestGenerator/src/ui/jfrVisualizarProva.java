/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import contracts.IMateria;
import contracts.IPergunta;
import contracts.IProva;
import javax.swing.JOptionPane;
import models.Pergunta;
import models.Prova;
import models.Resposta;
import repository.MateriaRepository;
import repository.PerguntaRepository;
import repository.ProvaRepository;

/**
 *
 * @author datacom
 */
public class jfrVisualizarProva extends javax.swing.JFrame {
    
    private IMateria srvMateria;
    private IPergunta srvPergunta;
    private IProva srvProva;
    private Prova _prova;
    private Boolean edicao;
    private Boolean gabarito;
    
    public jfrVisualizarProva() {        
        initComponents();
        setLocationRelativeTo(null);
        
        srvMateria = new MateriaRepository();
        srvPergunta = new PerguntaRepository(srvMateria);
        srvProva = new ProvaRepository(srvPergunta);
        carregarCampos();
        edicao = false;
    }
    
    public jfrVisualizarProva(int id, Boolean _gabarito) {        
        initComponents();
        setLocationRelativeTo(null);
        
        srvMateria = new MateriaRepository();
        srvPergunta = new PerguntaRepository(srvMateria);
        srvProva = new ProvaRepository(srvPergunta);
        _prova = srvProva.BuscarProva(id);   
        edicao = true;
        gabarito = _gabarito;
        carregarCampos();        
    }

    jfrVisualizarProva(Prova prova, Boolean _gabarito) {
        initComponents();    
        srvMateria = new MateriaRepository();
        srvPergunta = new PerguntaRepository(srvMateria);
        srvProva = new ProvaRepository(srvPergunta);
        _prova = prova;           
        edicao = false;
        gabarito = _gabarito;
        carregarCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtMateria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNivel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtProfessor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPerguntas = new javax.swing.JTextArea();
        btnSalvar = new javax.swing.JButton();
        btnGerar = new javax.swing.JButton();
        btnGabarito = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Prova");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Prova");

        txtMateria.setEditable(false);

        jLabel2.setText("Matéria:");

        jLabel3.setText("Nivel:");

        txtNivel.setEditable(false);

        jLabel4.setText("Data:");

        txtData.setEditable(false);

        jLabel5.setText("Professor:");

        txtProfessor.setEditable(false);

        txtPerguntas.setColumns(20);
        txtPerguntas.setEditable(false);
        txtPerguntas.setRows(5);
        jScrollPane1.setViewportView(txtPerguntas);

        btnSalvar.setText("Salvar Prova");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnGerar.setText("Gerar Prova");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        btnGabarito.setText("Gerar Gabarito");
        btnGabarito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGabaritoActionPerformed(evt);
            }
        });

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
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(51, 51, 51)
                        .addComponent(btnSalvar)
                        .addGap(27, 27, 27)
                        .addComponent(btnGerar)
                        .addGap(27, 27, 27)
                        .addComponent(btnGabarito)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProfessor)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnVoltar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtMateria)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)))
                                .addGap(18, 18, 18)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnSalvar)
                    .addComponent(btnGerar)
                    .addComponent(btnGabarito)
                    .addComponent(btnVoltar))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        srvProva.SalvarProva(_prova);
        JOptionPane.showMessageDialog(null, "Prova salvada com sucesso!");
        edicao = true;
        this.carregarCampos();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
  
        srvProva.GerarProva(_prova);
        JOptionPane.showMessageDialog(null, "Prova gerada com sucesso!");
    }//GEN-LAST:event_btnGerarActionPerformed

    private void btnGabaritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGabaritoActionPerformed
        srvProva.GerarGabarito(_prova);
        JOptionPane.showMessageDialog(null, "Gabarito da prova gerado com sucesso!");
    }//GEN-LAST:event_btnGabaritoActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        new jfrListarProvas().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    
    private void carregarCampos()
    {
        txtData.setText(_prova.Data());
        txtProfessor.setText(_prova.NomeProfessor()); 
        txtMateria.setText(_prova.Materia().toString());         
        
        if (edicao) {
            btnSalvar.setVisible(false);
        }
        
        StringBuffer texto = new StringBuffer();                          
        texto.append("Assinale a alternativa correta:\r\n \r\n");

        int nro = 1;
        for (Pergunta pergunta : _prova.BuscarPerguntas()) {
            texto.append(String.format("%s. %s \r\n", nro, pergunta.Descricao()));
            txtNivel.setText(pergunta.Nivel().toString());
            for (Resposta resposta : pergunta.BuscarRespostas()) {
                if (!gabarito) {
                    texto.append(String.format("( ) %s \r\n", resposta.Descricao()));                    
                } else
                {
                    if(resposta.Correta()) 
                        texto.append(String.format("(X) %s \r\n", resposta.Descricao()));                    
                    else       
                        texto.append(String.format("( ) %s \r\n", resposta.Descricao()));                                    
                }  
                                
            }                
            nro +=1;                
            texto.append("\r\n \r\n");
        }                
        
        txtPerguntas.setText(texto.toString());
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
            java.util.logging.Logger.getLogger(jfrVisualizarProva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new jfrVisualizarProva().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGabarito;
    private javax.swing.JButton btnGerar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtMateria;
    private javax.swing.JTextField txtNivel;
    private javax.swing.JTextArea txtPerguntas;
    private javax.swing.JTextField txtProfessor;
    // End of variables declaration//GEN-END:variables
}
