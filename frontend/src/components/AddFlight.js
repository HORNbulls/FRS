import React, { useEffect, useState } from "react";
import { API } from "../service/Service";
import "./AddFlight.css";

function AddFlight() {
  const flightID = window.location.pathname.split("/")[2];

  const [flights, setFlights] = useState({});

  useEffect(() => {
    if (flightID) {
      API.getFlightById(flightID).then((res) => {
        setFlights({
          flightID: res.flightID,
          flightName: res.flightName,
          seatingCapacity: res.seatingCapacity,
          reservationCapacity: res.reservationCapacity,
        });
      });
    }
  }, [flightID]);

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(JSON.stringify(flights));
    if (flightID) {
      API.updateFlight(flights).then((res) =>
        alert("Flight updated successfully")
      );
    } else {
      API.post(flights).then((res) => alert("Flight Added Successfully"));
    }
  };

  return (
  
    <div className="add-flight-background">
      <div className="add-flight-container">
        <h1 className="add-flight-title">ADD FLIGHT</h1>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label>Flight Name:</label>
            <input
              type="text"
              className="form-control"
              placeholder="Enter Flight Name"
              defaultValue={flights.flightName}
              onChange={(e) =>
                setFlights({ ...flights, flightName: e.target.value })
              }
            ></input>
          </div>
          <div className="form-group">
            <label>Flight Seating Capacity:</label>
            <input
              type="number"
              className="form-control"
              placeholder="Enter Seating Capacity"
              defaultValue={flights.seatingCapacity}
              onChange={(e) =>
                setFlights({ ...flights, seatingCapacity: e.target.value })
              }
            ></input>
          </div>
          <div className="form-group">
            <label>Enter Reservation Capacity:</label>
            <input
              type="number"
              className="form-control"
              placeholder="Enter Reservation Capacity"
              defaultValue={flights.reservationCapacity}
              onChange={(e) =>
                setFlights({
                  ...flights,
                  reservationCapacity: e.target.value,
                })
              }
            ></input>
          </div>
          <input className="btn1" type="submit" value="Submit"></input>
        </form>
      </div>
    </div>
  );
}

export default AddFlight;
