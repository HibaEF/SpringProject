package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.service.DetailProduitService;
import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.entity.Stock;

@RestController
@RequestMapping("/detailproduit")
public class DetailProduitRestController {
	@Autowired
	DetailProduitService dp;
	
	// http://localhost:8089/SpringMVC/detail-produit/retrieve-all-detail-produit
		@GetMapping("/retrieve-all-details-produits")
		@ResponseBody
		@ApiOperation(value = "Récupérer la liste de detail Produti")
		public List<DetailProduit> getDetailProduit(){
			List<DetailProduit> listDetailProduit=dp.retrieveAllDetailProduits();
			return listDetailProduit;
		}
		
		// http://localhost:8089/SpringMVC/detail-produit/add-detail-produit
				@PostMapping("/add-detail-produit")
				@ResponseBody
				@ApiOperation(value = "Ajouter detail produit")
				public DetailProduit addDetailProduit(@RequestBody DetailProduit d)
				{
					DetailProduit detprod = dp.addDetailProduit(d);
				return detprod;
				}
				// http://localhost:8089/SpringMVC/detail-produit/modify-detail-produit
				@PutMapping("/modify-detail-produit")
				@ResponseBody
				@ApiOperation(value = "Modifier detail produit")
				public DetailProduit modifyDetailProduit(@RequestBody DetailProduit d) {
				return dp.updateDetailProduit(d);
				}
				
				

}