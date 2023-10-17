import React from "react";

import {
  TextField,
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
  InputLabel,
  Select,
  Grid,
  Switch,
  Typography
} from "@material-ui/core";

import * as Commons from "../../commons.js";
import * as Constants from "../../constants.js";

import EditButton from "../../commons/EditButton.js";
import CancelButton from "../../commons/CancelButton.js";
import SaveButton from "../../commons/SaveButton.js";
import styles from "../../styles.js";

import './UpdateCoursePage.css';

class UpdateCoursePages extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      idItemToLoad: null,
      title: props.coursePage.title,
      code: props.coursePage.code,
      bodyText: props.coursePage.bodyText,
      owners: [],
      userId:"",
      selectedOwner: props.coursePage.selectedOwner,
      coursePageOwnerFirstname: props.coursePage.coursePageOwnerFirstname,
      coursePageOwnerLastname : props.coursePage.coursePageOwnerLastname,
      statusOpen : props.coursePage.statusOpen
    };
    this.gridRef = React.createRef();
  }

  handleChange = (event) => {
    this.setState(
      { [event.target.name]: event.target.value }
    );
  }

  handleSubmit = () => {
    const { title, code, bodyText,coursePageOwnerFirstname,coursePageOwnerLastname,userId,statusOpen } = this.state;
    const { coursePage } = this.props;

    const updatedCoursePage = {
      ...coursePage,
      title,
      code,
      bodyText,
      coursePageOwnerFirstname ,
      coursePageOwnerLastname,
      userId,
      statusOpen
    };

    console.log("item updatato " + JSON.stringify(updatedCoursePage))

    Commons.executeFetch(
      Constants.COURSEPAGE_CUSTOM_API + updatedCoursePage.id,
      "PUT",
      this.updateSuccess,
      Commons.operationError,
      JSON.stringify(updatedCoursePage),
      true
    );
  }

  updateSuccess = (response) => {
    Commons.operationSuccess();
    this.props.refreshCoursePagesList();
    this.setState({ isModalOpen: false });
  }

  cancelSubmit = (event) => {
    event.preventDefault();
    this.setState({ isModalOpen: false });
  }

  initializeAndShow = () => {
    console.log(this.props);
    console.log(this.props.idItemToUpdate);
  }

  componentDidMount = () => {
    this.fetchOwners();
  }

  fetchOwners = () => {
    Commons.executeFetch(Constants.BACKEND_API_PREFIX + Constants.GET_USER_BY_ROLE_API + "50", "GET", this.setOwners);
  }

  setOwners = (retrievedOwners) => {
    Commons.debugMessage("setOwners - START - owners: " + retrievedOwners);
    this.setState({
      owners: retrievedOwners,
    });
    console.log(retrievedOwners);
  }

  setItemToUpdate = (responseData) => {
    this.setState({
      itemLoaded: true,
      title: responseData.title,
      code: responseData.code,
      bodyText: responseData.bodyText,
    });
  }

  render() {
    return (
      <div>
        <Dialog
          open={this.state.isModalOpen}
          onClose={() => this.setState({ isModalOpen: false })}
        >
          <DialogTitle className="commonDialogTitle">MODIFICA POSIZIONE</DialogTitle>
          <DialogContent>
            <TextField
              fullWidth
              label="TITOLO POSIZIONE"
              name="title"
              value={this.state.title}
              onChange={this.handleChange}
              style={styles.field}
            />
            <TextField
              fullWidth
              label="CODICE ALFANUMERICO"
              name="code"
              value={this.state.code}
              onChange={this.handleChange}
              style={styles.field}
            />
            <TextField
              fullWidth
              label="BREVE DESCRIZIONE"
              name="bodyText"
              value={this.state.bodyText}
              onChange={this.handleChange}
              style={styles.fieldBeforeSelectWithLabel}
            />
            <InputLabel>HR RESPONSABILE DELLA POSIZIONE</InputLabel>
            <Select
              fullWidth
              label="Proprietario"
              name="proprietario"
              value={
                  this.state.selectedOwner!==undefined&&this.state.selectedOwner!==''&&this.state.selectedOwner!=='undefined'&&this.state.selectedOwner.length>0
                         ? this.state.selectedOwner
                         : (this.state.owners.filter(owner => owner.id===this.state.userId)[0])
              }
              onChange={(e) => this.setState(
                                { selectedOwner: e.target.value,
                                  coursePageOwnerFirstname : e.target.value.firstname,
                                  coursePageOwnerLastname : e.target.value.lastname,
                                  userId:e.target.value.id 
                                }
                       )}
              style={styles.fieldBeforeButtons}
            >
              {this.state.owners.map((owner) => (
                <option key={owner} value={owner}>{owner.firstname + " " + owner.lastname}</option>
              ))}
            </Select>
            <Grid container alignItems="center" justify="flex-start">
              <Grid item>
                <Typography variant="subtitle1" gutterBottom>
                  Stato:
                </Typography>
              </Grid>
              <Grid item>
                <Switch
                  checked={this.state.statusOpen}
                  onChange={(event) => this.setState({ statusOpen: event.target.checked })}
                  name="enabled"
                  inputProps={{ 'aria-label': 'Enable user' }}
                />
              </Grid>
            </Grid>
          </DialogContent>
          <DialogActions>
            <SaveButton onClick={() => this.handleSubmit()}/>
            <CancelButton onClick={() => this.setState({ isModalOpen: false })}/>
          </DialogActions>
        </Dialog>
        <div>
          <EditButton onClick={() => this.setState({ isModalOpen: true })} />
        </div>
      </div>
    );
  }
}

export default UpdateCoursePages;