import React, { useEffect, useState } from "react";
import { API } from "../service/Service";
import "bootstrap/dist/css/bootstrap.min.css";

function AddRoute() {
  const routeID = window.location.pathname.split("/")[2];
  const [route, setRoute] = useState({});
  const bgImage ="https://thumbs.dreamstime.com/b/airplane-flight-route-world-map-dotted-line-path-location-pin-vector-airplane-flight-route-world-map-dotted-129460341.jpg"
  const handleChange = (e) => {
    e.preventDefault();
    setRoute({ ...route, [e.target.name]: e.target.value });
  };

  useEffect(() => {
    if (routeID) {
      API.getRouteById(routeID).then((res) =>
        setRoute({
          routeID: res.routeID,
          source: res.source,
          destination: res.destination,
          distance: res.distance,
          fare: res.fare,
        })
      );
    }
  }, []);
  console.log(route);

  const handleSubmit = (e) => {
    e.preventDefault();
    if (routeID) {
      API.updateRoute(route).then((res) => alert("Route updated successfully"));
      console.log(route);
    } else {
      API.postRoutes(route).then((res) => alert("route added successfully"));
    }
  };

  return (
    <div
      style={{
        backgroundImage: `url(${bgImage})`,
        backgroundSize: "cover",
        minHeight: "100vh",
      }}
    >
      <div className="container mt-5">
        <h1 className="text-center mb-4">ADD ROUTE</h1>
        <div className="row justify-content-center">
          <div className="col-md-6">
            <div className="card">
              <div className="card-body">
                <form onSubmit={handleSubmit}>
                  <div className="form-group">
                    <label>Source:</label>
                    <input
                      type="text"
                      value={route.source}
                      className="form-control"
                      onChange={handleChange}
                      name="source"
                    ></input>
                  </div>
                  <div className="form-group">
                    <label>Destination:</label>
                    <input
                      type="text"
                      value={route.destination}
                      className="form-control"
                      onChange={handleChange}
                      name="destination"
                    ></input>
                  </div>
                  <div className="form-group">
                    <label>Distance:</label>
                    <input
                      type="text"
                      value={route.distance}
                      className="form-control"
                      onChange={handleChange}
                      name="distance"
                    ></input>
                  </div>
                  <div className="form-group">
                    <label>Fare:</label>
                    <input
                      type="text"
                      value={route.fare}
                      className="form-control"
                      onChange={handleChange}
                      name="fare"
                    ></input>
                  </div>
                  <br></br>
                  <button type="submit" className="btn1">
                    Submit
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default AddRoute;
