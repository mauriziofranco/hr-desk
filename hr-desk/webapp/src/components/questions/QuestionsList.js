import React, { Component } from "react";
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
} from "@material-ui/core";
import DeleteButton from "../../commons/DeleteButton.js";
import styles from "../../styles.js";

import { confirmAlert } from "react-confirm-alert";
import "react-confirm-alert/src/react-confirm-alert.css";
import AddQuestion from "./AddQuestion.js";
import UpdateQuestion from "./UpdateQuestion.js";
import * as Commons from "../../commons.js";
import PageMainTitle from "../../commons/PageMainTitle.js";

export default class QuestionsList extends Component {

  
  constructor(props) {
    super(props);
    this.state = { 
      items: [],
      uri: props.uri 
    };
  }

  componentDidMount() {
    this.getItems();
  }

  getItems = () => {
    Commons.executeFetch(
      this.state.uri,
      "GET",
      this.setItems
    );
  };

  setItems = (data) => {
    this.setState({
      items: data,
    });
  };

  confirmDelete = (id) => {
    confirmAlert({
      message: "Are you sure to delete?",
      buttons: [
        {
          label: "Yes",
          onClick: () => this.deleteItem(id),
        },
        {
          label: "No",
        },
      ],
    });
  };

  deleteItem(id) {
    Commons.executeDelete(
      this.state.uri + id,
      this.deleteSuccess,
      Commons.operationError
    );
  }

  deleteSuccess = (response) => {
    Commons.operationSuccess();
    this.getItems();
  };

  render() {
    return (
      <div style={styles.divContainer} className="App">
        <div className="panel panel-default">
          <PageMainTitle text={"DOMANDE DA INSERIRE NEI QUESTIONARI"} />
          <AddQuestion
              refreshList={this.getItems} 
              uri={this.state.uri} 
              dialogTitle={"INSERISCI UNA NUOVA DOMANDA"} 
              />
        </div>
        <TableContainer component={Paper}>
          <Table className={"table-style"}>
            <TableHead>
              <TableRow className={"table-head-row"}>

                <TableCell style={{ color: "#fff" }}>ID</TableCell>
                <TableCell style={{ color: "#fff" }}>TITOLO</TableCell>
                <TableCell style={{ color: "#fff" }}>DESCRIZIONE</TableCell>
                <TableCell style={{ color: "#333" }}></TableCell>
                <TableCell style={{ color: "#333" }}></TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {this.state.items.map((item, index) => (
                <TableRow
                  key={index}
                  className={
                    index % 2 === 0 ? "table-style-even-row" : "table-style-odd-row"
                  }
                >
                  <TableCell component="th" scope="row">
                    {item.id}
                  </TableCell>
                  <TableCell>{item.label}</TableCell>
                  <TableCell>{item.description}</TableCell>
                  <TableCell>
                      {/* <UpdateQuestion idItemToUpdate={item.id} refreshList={this.getItems} uri={this.state.uri} /> */}
                  </TableCell>
                  <TableCell>
                    <DeleteButton
                      onClick={() => this.confirmDelete(item.id)}
                    >
                      </DeleteButton>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </div>
    );
  }
}