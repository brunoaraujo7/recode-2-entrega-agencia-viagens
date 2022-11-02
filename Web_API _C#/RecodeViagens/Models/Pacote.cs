using System.ComponentModel.DataAnnotations.Schema;

namespace RecodeViagens.Models
{
    public class Pacote
    {
        public long Id { get; set; }

        [ForeignKey("id_destino")]
        public Destino Destino { get; set; }
        public double Valor { get; set; }
        public long Diaria { get; set; }
        public string Modal { get; set; }
    }
}
