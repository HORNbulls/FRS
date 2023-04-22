import React, { useEffect, useState } from "react";
import { API } from "../service/Service";
import "bootstrap/dist/css/bootstrap.min.css";
import { Link } from "react-router-dom";

function GetFlights() {
  const [flight, setFlight] = useState([]);

  useEffect(() => {
    API.get().then((res) => {
      setFlight(res);
    });
  }, []);
  console.log(flight);

  const deleteFlight = (id) => {
    let flight = window.confirm(`do you want delete${id}`);
    if (flight) {
      API.deleteFlight(id).then((res) => {
        setFlight(flight.filter((item) => item.flightID !== id));
      });
    } else {
      return;
    }
  };

  return (
    <div className="container mt-5">
      <h1 className="text-center mb-4">FLIGHT LIST</h1>
      <div className="table-responsive">
        <table className="table table-bordered table-hover">
          <thead className="table-light">
            <tr>
              <th>Flight ID</th>
              <th>Flight Name</th>
              <th>Seating Capacity</th>
              <th>Reservation Capacity</th>
              <td>Edit</td>
              <td>Delete</td>
            </tr>
          </thead>
          <tbody>
            {flight.map((flights) => (
              <tr key={flights.flightID}>
                <td>{flights.flightID}</td>
                <td>{flights.flightName}</td>
                <td>{flights.seatingCapacity}</td>
                <td>{flights.reservationCapacity}</td>
                <td>
                  <Link className="btn btn-warning" to={`/editFlight/${flights.flightID}`}>
                    Edit
                  </Link>
                </td>
                <td>
                  <button
                    className="btn btn-danger"
                    onClick={() => {
                      deleteFlight(flights.flightID);
                    }}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default GetFlights;
