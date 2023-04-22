import { Route, Routes } from "react-router-dom";
import "./App.css";
import AddFlight from "./components/AddFlight";
import GetFlights from "./components/GetFlights";
import ScheduleList from "./components/ScheduleList";
import AddSchedule from "./components/AddSchedule";
import AddRoute from "./components/AddRoute";
import RouteList from "./components/RouteList";
import Login from "./components/Login";

function App() {
  return (
    <div className="App">
      <Routes>
       <Route path="/" element={<Login />}></Route>
        <Route path="/getflights" element={<GetFlights />}></Route>
        
        <Route path="/addflight" element={<AddFlight />}></Route>
        <Route path="/viewSchedule" element={<ScheduleList />}></Route>
        <Route path="/addSchedule" element={<AddSchedule />}></Route>
        <Route path="/editFlight/:id" element={<AddFlight />}></Route>
        <Route path="/deleteFlight/:id" element={<AddFlight />}></Route>
        <Route path="/addRoute" element={<AddRoute />}></Route>
        <Route path="/getRoute" element={<RouteList />}></Route>
        <Route path="/editRoute/:id" element={<AddRoute />}></Route>
        
      </Routes>
    </div>
  );
}

export default App;