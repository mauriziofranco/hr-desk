import React from "react";
import * as Commons from "../commons.js";
import {
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
} from "@material-ui/core";
import AddButton from "./AddButton.js";
import CancelButton from "./CancelButton.js";
import SaveButton from "./SaveButton.js";

import './AddItemModal.css';

export default class AddItemModal extends React.Component {

  //
  //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  //MUST define in the constructor specialized class the state property isModalOpen
  //
  handleChange = (event) => {
    console.log(event.target.name + " - " + event.target.value);
    this.setState({ [event.target.name]: event.target.value });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    Commons.executeFetch(
      this.props.uri,
      "POST",
      this.insertSuccess,
      Commons.operationError,
      JSON.stringify(this.state),
      true
    );
  }

  insertSuccess = (response) => {
    Commons.operationSuccess();
    this.setState({ isModalOpen: false });
    this.props.refreshList();
  };

  cancelSubmit = (event) => {
    event.preventDefault();
    this.setState({ isModalOpen: false });
  };

  renderDialogContent = () => {
    return (
        <DialogContent>
            {/* OVERRIDE THIS METHOD WITH PROPER CONTENT */}
        </DialogContent>
    ) ;
}

  render() {
    return (
      <React.Fragment>
        <Dialog
          open={this.state.isModalOpen}
          onClose={() => this.setState({ isModalOpen: false })}
        >
          <DialogTitle>{this.props.dialogTitle}</DialogTitle>
          
          {this.renderDialogContent()}
          <DialogActions>
            <SaveButton
              onClick={this.handleSubmit}
            >
            </SaveButton>
            <CancelButton 
              onClick={this.cancelSubmit}
            >
            </CancelButton>
          </DialogActions>
        </Dialog>
          <AddButton
            onClick={() => this.setState({ isModalOpen: true })}
          >
          </AddButton>
      </React.Fragment>
    );
  }
}