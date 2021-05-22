import BarCharts from "components/BarChart";
import DataTable from "components/DataTable";
import DonutChart from "components/DonutsChart";
import Footer from "components/Footer";
import NavBar from "components/NavBar";
import React from "react";

const Dashboard = () => {
  return (
    <>
      <NavBar />
      <div className="container">
        <h1 className="text-primary py-3">Dashboard de Vendas</h1>
        <div className="row px-3">
          <div className="col-sm-6">
            <h5 className="text-center text-secondary">Taxa de sucesso (%)</h5>
            <BarCharts />
          </div>
          <div className="col-sm-6">
            <h5 className="text-center text-secondary">Todas vendas</h5>
            <DonutChart />
          </div>

        </div>

        <div className="py-3">
          <h2 className="text-primary">Todas as Vendas</h2>
          <DataTable />
        </div>

      </div>
      <Footer />
    </>
  );
}

export default Dashboard;