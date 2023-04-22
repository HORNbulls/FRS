import axios from "axios";

const BASEURL = "http://localhost:8080/admin";
//getting flight details
export const API = {
  get: async () => {
    const getting = await axios.get(BASEURL + "/getFlights");
    return getting.data;
  },
  //for adding flights
  post: async (data) => {
    const addFlight = await axios.post(BASEURL + "/addFlight", data);
    return addFlight.data;
  },

  //for updating flights
  updateFlight: async (data) => {
    const UpdateFlight = await axios.put(BASEURL + "/updateFlight", data);
    return UpdateFlight.data;
  },

  //for deleting flights
  deleteFlight: async (id) => {
    const deleteFlight = await axios.delete(`${BASEURL}/deleteFlight/${id}`);
    return deleteFlight.data;
  },

  //to view the schedules
  getSchedules: async () => {
    const getSchedules = await axios.get(BASEURL + "/viewSchedule");
    return getSchedules.data;
  },

  //to add schedules
  postSchedule: async (data) => {
    const addSchedule = await axios.post(BASEURL + "/addSchedule", data);
    return addSchedule.data;
  },

  //to view routes
  getRoute: async () => {
    const viewRoute = await axios.get(BASEURL + "/getRoute");
    return viewRoute.data;
  },

  //to get flights by id
  getFlightById: async (id) => {
    const Fid = await axios.get(`${BASEURL}/ViewFlightById/${id}`);
    return Fid.data;
  },

  //to get routes by id
  getRouteById: async (id) => {
    const Rid = await axios.get(`${BASEURL}/viewByRouteId/${id}`);
    return Rid.data;
  },

  //to add routes
  postRoutes: async (data) => {
    const AddRoute = await axios.post(`${BASEURL}/addRoute`, data);
    return AddRoute.data;
  },

  //to get routesList
  getRoutes: async () => {
    const RouteList = await axios.get(`${BASEURL}/getRoute`);
    return RouteList.data;
  },

  //To delete Route
  deleRoute: async (id) => {
    const deleteRoute = await axios.delete(`${BASEURL}/deleteRoute/${id}`);
    return deleteRoute.data;
  },

  //to update route
  updateRoute: async (data) => {
    const updaterout = await axios.put(`${BASEURL}/updateRoute`, data);
    return updaterout.data;
  },
};
