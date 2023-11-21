import React from "react";
import {
  TextField,
  DialogContent
} from "@material-ui/core";

import './AddQuestion.css';
import AddItemModal from "../../commons/AddItemModal.js";
import SingleQuestionInput from "./radioGroup/SingleQuestionInput.js";

export default class AddQuestion extends AddItemModal {

  constructor(props) {
    super(props);
    this.state = {
      label: "",
      description: "",
      ansa: "",
      ansb: null,
      ansc: "",
      ansd: "",
      anse: "",
      ansf: "",
      ansg: "",
      ansh: "",
      cansa: "",
      cansb: "",
      cansc: "",
      cansd: "",
      canse: "",
      cansf: "",
      cansg: "",
      cansh: "",
      fullAnswer: "",
      isModalOpen: false
    };
  }


  renderSingleQuestionInput = () => {

  }

  renderDialogContent = () => {
      return (
        <DialogContent>
          
          <TextField
            fullWidth
            label="testo della domanda"
            name="label"
            value={this.state.label}
            onChange={this.handleChange}
          />
          <TextField
            fullWidth
            multiline
            minRows={4}
            label="ulteriore dettaglio da aggiungere alla domanda"
            name="description"
            value={this.state.description}
            onChange={this.handleChange}
          />

          <SingleQuestionInput handleChange={this.handleChange} answerPropertyName="ansa" answerPlaceholder="Prima risposta" userAnswerPropertyName="cansa" />
          <SingleQuestionInput handleChange={this.handleChange} answerPropertyName="ansb" answerPlaceholder="Seconda risposta(opzionale)" userAnswerPropertyName="cansb" />
          <SingleQuestionInput handleChange={this.handleChange} answerPropertyName="ansc" answerPlaceholder="Terza risposta(opzionale)"   userAnswerPropertyName="cansc" />
          <SingleQuestionInput handleChange={this.handleChange} answerPropertyName="ansd" answerPlaceholder="Quarta risposta(opzionale)"  userAnswerPropertyName="cansd" />
          <SingleQuestionInput handleChange={this.handleChange} answerPropertyName="anse" answerPlaceholder="Quinta risposta(opzionale)"  userAnswerPropertyName="canse" />
          <SingleQuestionInput handleChange={this.handleChange} answerPropertyName="ansf" answerPlaceholder="Sesta risposta(opzionale)"   userAnswerPropertyName="cansf" />
          <SingleQuestionInput handleChange={this.handleChange} answerPropertyName="ansg" answerPlaceholder="Settima risposta(opzionale)" userAnswerPropertyName="cansg" />
          <SingleQuestionInput handleChange={this.handleChange} answerPropertyName="ansh" answerPlaceholder="Ottava risposta(opzionale)"  userAnswerPropertyName="cansh" />
          <TextField
            fullWidth
            multiline
            minRows={4}
            label="Risposta completa(e pienamente esaustiva) alla domanda"
            name="fullAnswer"
            value={this.state.fullAnswer}
            onChange={this.handleChange}
          />
        </DialogContent>
      ) ;
  }

}