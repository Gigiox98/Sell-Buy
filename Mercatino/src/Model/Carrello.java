/*
BSD 3-Clause License

Copyright (c) 2019, Mattia De Rosa
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, this
  list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice,
  this list of conditions and the following disclaimer in the documentation
  and/or other materials provided with the distribution.

* Neither the name of the copyright holder nor the names of its
  contributors may be used to endorse or promote products derived from
  this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package Model;

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * @author Mattia De Rosa
 *
 */
public class Carrello {
	
	private LinkedHashMap<String, ProdottoQuantita> prodotti = new LinkedHashMap<>();

	public Collection<ProdottoQuantita> getProdotti() {
		return prodotti.values();
	}

	public ProdottoQuantita get(String prodId) {
		return prodotti.get(prodId);
	}

	public void put(Prodotto prodotto, int quantita) {
		prodotti.put(prodotto.getCodice(), new ProdottoQuantita(prodotto, quantita));
	}

	public ProdottoQuantita remove(String prodId) {
		return prodotti.remove(prodId);
	}

	@Override
	public String toString() {
		return "Carrello [prodotti=" + prodotti + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prodotti == null) ? 0 : prodotti.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrello other = (Carrello) obj;
		if (prodotti == null) {
			if (other.prodotti != null)
				return false;
		} else if (!prodotti.equals(other.prodotti))
			return false;
		return true;
	}

}
