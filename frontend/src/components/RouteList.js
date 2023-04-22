import React, { useEffect, useState } from "react";
import { API } from "../service/Service";
import "bootstrap/dist/css/bootstrap.min.css";
import { Link } from "react-router-dom";

function RouteList() {
  const [route, setRoute] = useState([]);

  useEffect(() => {
    API.getRoute().then((res) => setRoute(res));
  }, []);
  console.log(route);

  const deleteRoute = (id) => {
    let routeID = window.confirm(`do you want to delete${id}`);
    if (routeID) {
      API.deleRoute(id).then((res) =>
        setRoute(route.filter((item) => item.routeID !== id))
      );
    } else {
      return;
    }
  };

  return (
    <div className="container mt-5">
      <h1 className="text-center mb-4">ROUTE LIST</h1>
      <div className="row justify-content-center">
        <div className="col-md-12">
          <div className="card">
            <div className="card-body">
              <table className="table table-bordered table-striped">
                <thead>
                  <tr>
                    <th>Route ID</th>
                    <th>Source</th>
                    <th>Destination</th>
                    <th>Distance</th>
                    <th>Fare</th>
                    <th>Edit</th>
                    <th>Delete</th>
                  </tr>
                </thead>
                <tbody>
                  {route.map((rou) => {
                    return (
                      <tr key={rou.routeID}>
                        <td>{rou.routeID}</td>
                        <td>{rou.source}</td>
                        <td>{rou.destination}</td>
                        <td>{rou.distance}</td>
                        <td>{rou.fare}</td>
                        <td>
                          <Link
                            to={`/editRoute/${rou.routeID}`}
                            className="btn btn-primary"
                          >
                            Edit
                          </Link>
                        </td>
                        <td>
                          <button
                            onClick={() => {
                              deleteRoute(rou.routeID);
                            }}
                            className="btn btn-danger"
                          >
                            Delete
                          </button>
                        </td>
                      </tr>
                    );
                  })}
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default RouteList;
